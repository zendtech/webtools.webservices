package org.eclipse.wst.wsdl.ui.internal;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

public class Messages {
	private static final String BUNDLE_NAME = "org.eclipse.wst.wsdl.ui.internal.messages"; //$NON-NLS-1$

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class); //$NON-NLS-1$
	}
		private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		// TODO Auto-generated method stub
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String getString(String key, String arg0) {
		return MessageFormat.format(getString(key), new Object [] { arg0 });
	}

	public static String _UI_DEPENDENCIES_CHANGED;
	public static String _UI_DEPENDENCIES_CHANGED_REFRESH;
	public static String _UI_EDIT_NAMESPACES_DIALOG_TITLE;
	public static String _UI_PREF_PAGE_CREATING_FILES;
	public static String _UI_REMEMBER_MY_DECISION_LABEL;
	public static String _UI_PREF_PAGE_DEFAULT_TARGET_NAMESPACE;
	public static String _UI_REGEN_BINDINGS_ON_SAVE_QUESTIONMARK;
	public static String _UI_LABEL_WARNING_DUPLICATE_NAME_EXISTS;
	public static String _UI_LABEL_NAMESPACE_URIS_TO_BE_INCLUDED;
	public static String _UI_PREF_PAGE_AUTO_REGENERATE_BINDING;
	public static String _UI_PREF_PAGE_PROMPT_REGEN_BINDING_ON_SAVE;
	public static String _UI_EDIT_NAMESPACES;
	public static String _UI_ACTION_ADD_IMPORT;
	public static String _UI_ACTION_ADD_BINDING;
	public static String _UI_ACTION_ADD_PART;
	public static String _UI_ACTION_REORDER_PART;
	public static String _UI_ACTION_REORDER_MESSAGE_REFERENCE;
	public static String _UI_ACTION_OPEN_IN_NEW_EDITOR;
	public static String _UI_ACTION_EXISTING_MESSAGE;
	public static String _UI_ACTION_EXISTING_ELEMENT;
	public static String _UI_ERROR_NAMESPACE_INVALID;
	public static String _UI_ERROR_FILE_ALREADY_EXISTS;
	public static String _UI_DESCRIPTION_NEW_WSDL_FILE;
	public static String _UI_REGEN_BINDINDS_ON_SAVE;
	public static String _UI_RADIO_DOCUMENT_LITERAL;
	public static String _UI_TITLE_SPECIFY_PORTTYPE;
	public static String _UI_LABEL_BINDING_PROTOCOL;
	public static String _UI_LABEL_INLINE_SCHEMA_OF;
	public static String _UI_LABEL_TARGET_NAMESPACE;
	public static String _UI_LABEL_PREFIX_WITH_COLON;
	public static String _UI_LABEL_CREATE_WSDL_SKELETON;
	public static String _UI_LABEL_CREATE_NEW_WSDL_FILE;
	public static String _UI_LABEL_SOAP_BINDING_OPTIONS;
	public static String _UI_LABEL_HTTP_BINDING_OPTIONS;
	public static String _UI_LABEL_ADD_EXTENSION_ELEMENT;
	public static String _UI_SPECIFY_BINDING_DETAILS_LABEL;
	public static String _UI_SPECIFY_PORT_DETAILS_TO_BE_CREATED;
	public static String _UI_LABEL_NEW_BINDING;
	public static String _UI_LABEL_NEW_PORTTYPE;
	public static String _UI_LABEL_REFERENCE_KIND;
	public static String _UI_LABEL_NEW_MESSAGE;
	public static String _UI_RADIO_RPC_ENCODED;
	public static String _UI_RADIO_RPC_LITERAL;
	public static String _UI_ACTION_EXISTING_TYPE;
	public static String _UI_SPECIFY_PORT_DETAILS;
	public static String _UI_TITLE_SPECIFY_BINDING;
	public static String _UI_TITLE_SPECIFY_BINDING_DETAILS;
	public static String _UI_ERROR_FILE_MUST_END_WITH_WSDL;
	public static String _UI_TITLE_SPECIFY_MESSAGE;
	public static String _UI_TITLE_NEW_WSDL_FILE;
	public static String _UI_NAME_INVALID_CHAR_END;
	public static String _UI_ACTION_RENAME;
	public static String _UI_FOLDER_TYPES;
	public static String _UI_CANCEL_LABEL;
	public static String _UI_ACTION_NEW_TYPE;
	public static String _UI_ACTION_SET_TYPE;
	public static String _UI_FOLDER_IMPORTS;
	public static String _UI_FOLDER_SERVICES;
	public static String _UI_FOLDER_BINDINGS;
	public static String _UI_FOLDER_INTERFACES;
	public static String _UI_FOLDER_PORTTYPES;
	public static String _UI_FOLDER_MESSAGES;
	public static String _UI_ACTION_NEW_MESSAGE;
	public static String _UI_ACTION_NEW_ELEMENT;
	public static String _UI_ACTION_SET_ELEMENT;
	public static String _UI_ACTION_SET_MESSAGE;
	public static String _UI_ACTION_SET_BINDING;
	public static String _UI_CHECKBOX_OVERWRITE;
	public static String _UI_ACTION_SET_PORTTYPE;
	public static String _UI_ACTION_ADD;
	public static String _UI_ACTION_OPEN_IMPORT;
	public static String _UI_UNSPECIFIED;
	public static String _UI_LABEL_NAME;
	public static String _UI_LABEL_TYPE;
	public static String _UI_BUTTON_NEW;
	public static String _UI_LABEL_ELEMENT;
	public static String _UI_BUTTON_BROWSE;
	public static String _UI_BINDING_WIZARD;
	public static String _UI_BINDING;
	public static String _UI_LABEL_MESSAGE;
	public static String _UI_LABEL_REMOVE;
	public static String _UI_TITLE_SELECT;
	public static String _UI_TITLE_SELECT_FILE;
	public static String _UI_DESCRIPTION_SELECT_WSDL_OR_XSD;
	public static String _UI_TITLE_OPTIONS;
	public static String _UI_YES_LABEL;
	public static String _UI_PORT_TYPE;
	public static String _UI_PORT_WIZARD;
	public static String _UI_NO_LABEL;
	public static String _UI_ADD;
	public static String _UI_HELP;
	public static String _UI_LABEL_NAME_FILTER;
	public static String _WARN_NAME_MUST_CONTAIN_AT_LEAST_ONE_CHAR;
	public static String _WARN_NAME_HAS_SPACE;
	public static String _WARN_NAME_INVALID_FIRST;
	public static String _WARN_NAME_INVALID_CHAR;
}