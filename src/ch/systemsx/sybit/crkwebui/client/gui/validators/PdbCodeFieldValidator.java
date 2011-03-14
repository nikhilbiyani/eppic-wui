package ch.systemsx.sybit.crkwebui.client.gui.validators;

import ch.systemsx.sybit.crkwebui.shared.PdbCodeVerifier;

import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Validator;

public class PdbCodeFieldValidator implements Validator {

	@Override
	public String validate(Field<?> field, String value) {
		String validationResult = null;

		if (!PdbCodeVerifier.isValid(value)) {
			validationResult = value + " is not a correct PDB code";
		}

		return validationResult;
	}

}