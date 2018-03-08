#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.modelvalidators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <p>
 * The validator used by the SampleCustomJSR303ValidatorAnnotation annotation for validating
 * someInputValue.
 * </p>
 * <p>
 * Note that the {@code ConstraintValidator}'s generic "{@code Object}" in the {@code implements} clause
 * must be changed to a {@code *Request} model object generated from the modelvalidators XSD.
 * </p>
 */
public class SampleCustomJSR303Validator
		implements ConstraintValidator<SampleCustomJSR303ValidatorAnnotation, Object> {

	private static final String SOME_DEFAULT_VALUE = "{someInputValue}";
	private static final String SOME_PATTERN = "(^${symbol_dollar}|[A-Z]{2})"; // empty string or 2 uppercase letters

	/**
	 * Validates the specified input valaue. Must be empty string, or two uppercase
	 * letters.
	 *
	 * @param someInputValue
	 *            data to validate
	 * @param context
	 *            provides bean validation engine functionality
	 *
	 * @return {@code true} if someInputValue is valid, {@code false} if not
	 */
	@Override
	// Object must be changed to a *Request model that was generated from the modelvalidators XSD.
	public final boolean isValid(final Object request,
			final ConstraintValidatorContext context) {

		return validateSomeInputValue(request.getSomeInputValue(), context);

	}

	/**
	 * Validates the someInputValue to enforce empty string, or two uppercase letters.
	 *
	 * @param someInputValue
	 *            to validate
	 * @param context
	 *            provides bean validation engine functionality
	 *
	 * @return {@code true} if someInputValue is valid, {@code false} if not
	 */
	private boolean validateSomeInputValue(final String someInputValue, final ConstraintValidatorContext context) {
		boolean valid = true;

		// Required properties

		if ((someInputValue == null) || "".equals(someInputValue) || SOME_DEFAULT_VALUE.equals(someInputValue)) {
			return valid;
		} else {
			if ((someInputValue.length() > 2) || !Pattern.matches(SOME_PATTERN, someInputValue)
					|| !StatesUtil.allStates().contains(someInputValue)) {
				final ConstraintValidatorContext.ConstraintViolationBuilder builder = context
						.buildConstraintViolationWithTemplate(""); // change to: ${artifactName}MessageKeys.SOME_MESSAGE_KEY_CONSTANT);
				builder.addConstraintViolation();
				valid = false;
			}
		}

		return valid;
	}

	@Override
	public void initialize(final SampleCustomJSR303ValidatorAnnotation constraintAnnotation) {
		/**
		 * This is an overridden method that can be empty
		 */
	}
}
