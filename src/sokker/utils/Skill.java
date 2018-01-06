package sokker.utils;

public enum Skill {
	PACE{
		@Override
		public String toString() {
			return "Szybkoœæ";
		}
	},
	PASSES{
		@Override
		public String toString() {
			return "Podania";
		}
	},
	PLAYMAKING{
		@Override
		public String toString() {
			return "Rozgrywaj¹cy";
		}
	},
	DEFENDING{
		@Override
		public String toString() {
			return "Obroñca";
		}
	},
	STRIKER{
		@Override
		public String toString() {
			return "Strzelec";
		}
	},
	TECHNIQUE{
		@Override
		public String toString() {
			return "Technika";
		}
	},
	GOALKEEPING{
		@Override
		public String toString() {
			return "Bramkarz";
		}
	},
	STAMINA{
		@Override
		public String toString() {
			return "Kondycja";
		}
	},
	FORM{
		@Override
		public String toString() {
			return "Forma";
		}
	},
	VALUE{
		@Override
		public String toString() {
			return "Wartoœæ";
		}
	},
	WAGE{
		@Override
		public String toString() {
			return "P³aca";
		}
	};
	
	public Skill getSkill(int i) {
		switch (i) {
		case 0: return Skill.PACE;
		case 1: return Skill.PASSES;
		case 2: return Skill.PLAYMAKING;
		case 3: return Skill.DEFENDING;
		case 4: return Skill.STRIKER;
		case 5: return Skill.TECHNIQUE;
		case 6: return Skill.GOALKEEPING;
		case 7: return Skill.STAMINA;
		case 8: return Skill.FORM;
		case 9: return Skill.VALUE;
		case 10: return Skill.WAGE;
		}
		return null;
	}
	public int getSkillInt(Skill skill) {
		switch (skill) {
		case PACE: return 0;
		case PASSES: return 1;
		case PLAYMAKING: return 2;
		case DEFENDING: return 3;
		case STRIKER: return 4;
		case TECHNIQUE: return 5;
		case GOALKEEPING: return 6;
		case STAMINA: return 7;
		case FORM: return 8;
		case VALUE: return 9;
		case WAGE: return 10;
		}
		return -1;
	}
	
	public Skill getNextSkill(Skill skill) {
		int current = skill.getSkillInt(skill);
		if (skill.getSkill(current+1) == null){
			return PACE;
		} else {
			return skill.getSkill(current+1);
		}
	}
	public Skill getPreviousSkill(Skill skill) {
		int current = skill.getSkillInt(skill);
		if (skill.getSkill(current-1) == null){
			return WAGE;
		} else {
			return skill.getSkill(current-1);
		}
	}
	
	
}
