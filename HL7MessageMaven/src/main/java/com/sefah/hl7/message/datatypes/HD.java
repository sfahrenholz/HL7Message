package com.sefah.hl7.message.datatypes;

import com.sefah.hl7.message.components.HL7Repetition;

/**
 * Components: <namespace ID (IS)> ^ <universal ID (ST)> ^ <universal ID type
 * (ID)>
 * 
 * Example: "ACME Pathology^2184^AUSNATA"
 * 
 * The HD is designed to be more powerful and more general replacement for the
 * application identifier of HL7 versions 2.1 and 2.2. It adds two additional
 * components, the <universal ID> and the <universal ID type> to the former
 * application ID (which is renamed more generically to be the namespace ID) The
 * basic definition of the HD is that it identifies an (administrative or system
 * or application or other) entity that has responsibility for managing or
 * assigning a defined set of instance identifiers (such as placer or filler
 * number, patient identifiers, provider identifiers, etc.). This entity could
 * be a particular health care application such as a registration system that
 * assigns patient identifiers, a governmental entity such as a licensing
 * authority that assigns professional identifiers or drivers license numbers,
 * or a facility where such identifiers are assigned.
 * 
 * @author Sebastian Fahrenholz
 *
 */
public class HD extends Datatype {
	public HD(HL7Repetition datatype) {
		super(datatype);
	}

	/**
	 * Namespace ID is used as the HL7 identifier for the user-defined table of
	 * values for this component.
	 * 
	 * @return
	 */
	public String getNamespaceId() {
		return repetitionValue.getHL7ComponentValue(0);
	}

	/**
	 * The HDs second component, <universal ID> (UID), is a string formatted
	 * according to the scheme defined by the third component, <universal ID type>
	 * (UID type). The UID is intended to be unique over time within the UID type.
	 * It is rigorously defined. Each UID must belong to one of the specifically
	 * enumerated schemes for constructing UIDs (defined by the UID type). The UID
	 * (second component) must follow the syntactic rules of the particular
	 * universal identifier scheme (defined by the third component). Note that these
	 * syntactic rules are not defined within HL7 but are defined by the rules of
	 * the particular universal identifier scheme (defined by the third component).
	 * 
	 * @return
	 */
	public String getUniversalId() {
		return repetitionValue.getHL7ComponentValue(1);
	}

	/**
	 * The third component governs the interpretation of the second component of the
	 * HD. If the third component is a known UID refer to HL7 Table 0301 - Universal
	 * ID type for valid values, then the second component is a universal ID of that
	 * type.
	 * 
	 * @return
	 */
	public String getUniversalIdType() {
		return repetitionValue.getHL7ComponentValue(2);
	}
}
