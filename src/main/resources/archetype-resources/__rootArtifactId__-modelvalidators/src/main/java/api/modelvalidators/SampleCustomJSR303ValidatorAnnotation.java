#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.modelvalidators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Annotation for JSR303 custom validation of SampleCustomJSR303Validator. 
 * Note that the validator allows SampleCustomJSR303Validator to be an empty string.
 */
@Target({ ElementType.TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { SampleCustomJSR303Validator.class })
public @interface SampleCustomJSR303ValidatorAnnotation {
	/**
	 * Validation failure message displayed to user.
	 *
	 * @return the string
	 */
	String message() default "{${artifactNameLowerCase}.somerestoperationinputvalue.invalid}";

	/**
	 * Validation groups to which this constraint applies.
	 *
	 * @return the class[]
	 */
	Class<?>[] groups() default {};

	/**
	 * Payload delivered to constraint validator implementation.
	 *
	 * @return the class<? extends payload>[]
	 */
	Class<? extends Payload>[] payload() default {};

}
