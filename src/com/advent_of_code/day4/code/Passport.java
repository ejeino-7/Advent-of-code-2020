package com.advent_of_code.day4.code;

public class Passport {

	private int byr = -1;
	private int iyr = -1;
	private int eyr = -1;
	private int hgt = -1;
	private String hgtUnit = "";
	private String hcl;
	private EyeColor ecl = EyeColor.INVALID;
	private String pid = "";
	private boolean cid = false;
	private boolean isValid;

	public Passport(String row) {
		isValid = true;
		if (row.contains("byr:")) {
			byr = Integer.parseInt(row.split("byr:")[1].split(" ")[0]);
		} else {
			isValid = false;
		}
		if (row.contains("iyr:")) {
			iyr = Integer.parseInt(row.split("iyr:")[1].split(" ")[0]);
		} else {
			isValid = false;
		}
		if (row.contains("eyr:")) {
			eyr = Integer.parseInt(row.split("eyr:")[1].split(" ")[0]);
		} else {
			isValid = false;
		}

		if (row.contains("hgt:")) {
			String pr = row.split("hgt:")[1].split(" ")[0];
			if (pr.contains("cm")) {
				hgtUnit = "cm";
				hgt = Integer.parseInt(pr.split("cm")[0]);
			} else if (pr.contains("in")) {
				hgtUnit = "in";
				hgt = Integer.parseInt(pr.split("in")[0]);
			}
		} else {
			isValid = false;
		}
		if(row.contains("hcl:")) {
			hcl = row.split("hcl:")[1].split(" ")[0];
		} else {
			isValid = false;
		}
		if (row.contains("ecl:")) {
			ecl = EyeColor.getByString(row.split("ecl:")[1].split(" ")[0]);
		} else {
			isValid = false;
		}
		if (row.contains("pid:")) {
			pid = row.split("pid:")[1].split(" ")[0];
		} else {
			isValid = false;
		}
		if (row.contains("cid:")) {
			cid = true;
		}

	}

	public boolean isValid() {

		return isValid;
	}

	public boolean isCorrect() {
		boolean correct = true;

		if (byr < 1920 || byr > 2002)
			correct = false;
		if (iyr < 2010 || iyr > 2020)
			correct = false;
		if (eyr < 2020 || eyr > 2030)
			correct = false;
		if (hgtUnit.equals("cm")) {
			if (hgt < 150 || hgt > 193) {
				correct = false;
			}
		} else if (hgtUnit.equals("in")) {
			if (hgt < 59 || hgt > 76) {
				correct = false;
			}
		} else {
			correct = false;
		}
		if(hcl != null) {
			if(hcl.charAt(0) == '#' && hcl.length() == 7) {
				for(int i = 1; i < hcl.length(); i++) {
					if(!"0123456789abcdefABCDEF".contains(""+hcl.charAt(i))) {
						correct = false;
					}
				}
			} else {
				correct = false;
			}
		} else 
			correct = false;
		
		if (ecl == EyeColor.INVALID)
			correct = false;
		if (pid.length() != 9)
			correct = false;
		try {
			Integer.parseInt(pid);
		} catch (NumberFormatException e) {
			correct = false;
		}

		return correct;
	}

	public void setByr(int byr) {
		this.byr = byr;
	}

	public void setIyr(int iyr) {
		this.iyr = iyr;
	}

	public void setEyr(int eyr) {
		this.eyr = eyr;
	}

	public void setHgt(int hgt) {
		this.hgt = hgt;
	}

	public void setHgtUnit(String hgtUnit) {
		this.hgtUnit = hgtUnit;
	}

	public void setHcl(String hcl) {
		this.hcl = hcl;
	}

	public void setEcl(EyeColor ecl) {
		this.ecl = ecl;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setCid(boolean cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Passport [byr=");
		builder.append(byr);
		builder.append(", iyr=");
		builder.append(iyr);
		builder.append(", eyr=");
		builder.append(eyr);
		builder.append(", hgt=");
		builder.append(hgt);
		builder.append(", hgtUnit=");
		builder.append(hgtUnit);
		builder.append(", hcl=");
		builder.append(hcl);
		builder.append(", ecl=");
		builder.append(ecl);
		builder.append(", pid=");
		builder.append(pid);
		builder.append(", cid=");
		builder.append(cid);
		builder.append(", isValid=");
		builder.append(isValid);
		builder.append("]");
		return builder.toString();
	}

	

}

enum EyeColor {
	amb, blu, brn, gry, grn, hzl, oth, INVALID;

	public static EyeColor getByString(String name) {
		if (name.equals("amb")) {
			return amb;
		} else if (name.equals("blu")) {
			return blu;
		} else if(name.equals("brn")) {
			return brn;
		} else if (name.equals("gry")) {
			return gry;
		} else if (name.equals("grn")) {
			return grn;
		} else if (name.equals("hzl")) {
			return hzl;
		} else if (name.equals("oth")) {
			return oth;
		} else {
			return INVALID;
		}
	}
}
