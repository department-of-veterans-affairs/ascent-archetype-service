#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.modelvalidators.keys;

/**
 * Project message keys for jsr303 custom validators
 *
 * @author
 */
// Using interface so it works with the error key generator for display
// CHECKSTYLE:OFF
public interface ${artifactName}MessageKeys {
	// CHECKSTYLE:ON

	/* key for service.error */
	public static final String ${artifactNameUpperCase}_SERVICE_ERROR = "${artifactNameLowerCase}.service.error";
	/* key for partner.service.error */
	public static final String ${artifactNameUpperCase}_PARTNER_ERROR = "${artifactNameLowerCase}.partner.service.error";
	/* key for parnter.service.invalid */
	public static final String ${artifactNameUpperCase}_PARTNER_INVALID_ERROR = "${artifactNameLowerCase}.partner.service.invalid";
	/* key for common.fallback.error */
	public static final String ${artifactNameUpperCase}_COMMON_FALLBACK_ERROR = "${artifactNameLowerCase}.common.fallback.error";

	/* Add any additional message key constants here, for example:
	public static final String ${artifactNameUpperCase}_SPECIFIER_INFO_ERROR = "${artifactNameLowerCase}.specifier.info.error";
	*/
}
