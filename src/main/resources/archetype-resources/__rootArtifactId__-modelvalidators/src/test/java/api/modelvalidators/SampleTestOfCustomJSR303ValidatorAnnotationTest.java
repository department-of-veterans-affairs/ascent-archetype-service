#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.modelvalidators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gov.va.ascent.framework.util.Defense;

public class SampleTestOfCustomJSR303ValidatorAnnotationTest {

	private SampleCustomJSR303Validator validator;

	@Mock
	ConstraintValidatorContext constraintValidatorContext;

	@Mock
	ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilder;

	/*
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		Defense.notNull(constraintValidatorContext);
		Defense.notNull(constraintViolationBuilder);

		when(constraintValidatorContext.buildConstraintViolationWithTemplate(any(String.class)))
				.thenReturn(constraintViolationBuilder);

		validator = new ${artifactName}SomeValidator();
		validator.initialize(null);
	}

	@Test
	public void testIsValid_happypath() {
		final SomeRequest request = new SomeRequest();
		request.setSomeInputValue("SomeValidValue");
		boolean isValid = validator.isValid(request, constraintValidatorContext);
		assertTrue(isValid);
	}

	@Test
	public void testIsValid_nullInputValue() {
		final SomeRequest request = new SomeRequest();
		boolean isValid = validator.isValid(request, constraintValidatorContext);
		assertTrue(isValid);
		request.setSomeInputValue(null);
		isValid = validator.isValid(request, constraintValidatorContext);
		assertTrueOrFalse(isValid);
	}

	@Test
	public void testIsValid_invalidInputValue() {
		final SomeRequest request = new SomeRequest();
		request.setStateCode("SomeInvalidValue");
		boolean isValid = validator.isValid(request, constraintValidatorContext);
		assertFalse(isValid);
	}
	*/
}