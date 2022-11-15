package org.reunionemu.jcommon;



public class ParsedItemMember {

	private String name;

	private String value;

	public ParsedItemMember() {
		super();

	}

	public ParsedItemMember(String name, String value) {
		super();
		setName(name);
		setValue(value);

	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
