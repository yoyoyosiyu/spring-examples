package com.huayutech.annotation.annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;

import java.util.*;

@Order(Ordered.LOWEST_PRECEDENCE)
public class CheckBeanMissingCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        Map<String, Object> attrs  = annotatedTypeMetadata.getAnnotationAttributes(ConditionalOnMissingBean.class.getName());

        if (annotatedTypeMetadata.isAnnotated(ConditionalOnMissingBean.class.getName())) {
            BeanSearchSpec beans = new BeanSearchSpec(conditionContext, annotatedTypeMetadata, ConditionalOnMissingBean.class);

            List<String> types = beans.getTypes();

            ListableBeanFactory beanFactory = conditionContext.getBeanFactory();

            Collection<String> names = null;

            for (String type: types) {
                try {

                    names = getBeanNamesForType(beanFactory, type, conditionContext.getClassLoader(), true);
                }
                catch(Exception e) {

                }
            }


        }

        return true;
    }

    private Collection<String> getBeanNamesForType(ListableBeanFactory beanFactory, String type, ClassLoader classLoader, boolean considerHierarchy) {

        try {
            Set<String> result = new LinkedHashSet<>();
            collectBeanNamesForType(result, beanFactory, ClassUtils.forName(type, classLoader), considerHierarchy);
            return result;
        }
        catch (Exception e) {
            return Collections.emptySet();
        }

    }

    private void collectBeanNamesForType(Set<String> result,
             ListableBeanFactory beanFactory, Class<?> type, boolean considerHierarchy) {

        String[] names = beanFactory.getBeanNamesForType(type);

        result.addAll(Arrays.asList(beanFactory.getBeanNamesForType(type)));

        if (considerHierarchy && beanFactory instanceof HierarchicalBeanFactory) {
            BeanFactory parent = ((HierarchicalBeanFactory) beanFactory).getParentBeanFactory();

            if (parent instanceof ListableBeanFactory) {
                collectBeanNamesForType(result, (ListableBeanFactory) parent, type, considerHierarchy);
            }
        }
    }



    private static class BeanSearchSpec {

        private final List<String> types = new ArrayList<>();

        BeanSearchSpec(ConditionContext context, AnnotatedTypeMetadata metadata, Class<?> annotationType) {

            MultiValueMap<String, Object> attributes = metadata.getAllAnnotationAttributes(annotationType.getName(), true);

            collect(attributes, "value", this.types);

        }

        private void collect(MultiValueMap<String, Object> attributes, String key, List<String> destination) {
            List<?> values = attributes.get(key);

            if (values != null) {
                for (Object value: values) {
                    if (value instanceof List) {
                        Collections.addAll(destination, (String[])value);
                    }
                    else {
                        destination.add((String)value);
                    }
                }
            }
        }

        public List<String> getTypes() {
            return this.types;
        }
    }
}
