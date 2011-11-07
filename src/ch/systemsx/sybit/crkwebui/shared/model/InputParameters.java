package ch.systemsx.sybit.crkwebui.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to transfer parameters selected by the user
 * @author srebniak_a
 *
 */
public class InputParameters implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> methods;

	private boolean usePISA;
	private boolean useNACCESS;

	private int asaCalc;
	private int maxNrOfSequences;
	private int reducedAlphabet;

	private float identityCutoff;
	private float selecton;

	public InputParameters() 
	{
		this.methods = new ArrayList<String>();
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	public boolean isUsePISA() {
		return usePISA;
	}

	public void setUsePISA(boolean usePISA) {
		this.usePISA = usePISA;
	}

	public boolean isUseNACCESS() {
		return useNACCESS;
	}

	public void setUseNACCESS(boolean useNACCESS) {
		this.useNACCESS = useNACCESS;
	}

	public int getAsaCalc() {
		return asaCalc;
	}

	public void setAsaCalc(int asaCalc) {
		this.asaCalc = asaCalc;
	}

	public int getMaxNrOfSequences() {
		return maxNrOfSequences;
	}

	public void setMaxNrOfSequences(int maxNrOfSequences) {
		this.maxNrOfSequences = maxNrOfSequences;
	}

	public int getReducedAlphabet() {
		return reducedAlphabet;
	}

	public void setReducedAlphabet(int reducedAlphabet) {
		this.reducedAlphabet = reducedAlphabet;
	}

	public float getIdentityCutoff() {
		return identityCutoff;
	}

	public void setIdentityCutoff(float identityCutoff) {
		this.identityCutoff = identityCutoff;
	}

	public float getSelecton() {
		return selecton;
	}

	public void setSelecton(float selecton) {
		this.selecton = selecton;
	}
}
