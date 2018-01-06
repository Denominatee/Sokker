package sokker.scaner.utils;

public enum CSS {
	
	LOGIN{
		@Override
		public String toString() {
			return "input[id=ilogin]";
		}
	},
	PASSWORD{
		@Override
		public String toString() {
			return "input[id=ipassword]";
		}
	},
	LOGIN_BTN{
		@Override
		public String toString() {
			return "div.col-sm-offset-4.col-sm-8>button";
		}
	},
	TEAM_BTN{
		@Override
		public String toString() {
			return "a.btn.btn-default.navbar-btn.bar-btn-iconNavi3";
		}
	},
	STATS_BTN{
		@Override
		public String toString() {
			return "div[id=bs-example-navbar-collapse-1]>ul>li:nth-of-type(7)>a";
		}
	},
	STATS_RANK{
		@Override
		public String toString() {
			return "div.panel-body>table>tbody>tr:nth-of-type(1)>td:nth-of-type(2)";
		}
	},
	STATS_NUM_OF_PLAYERS{
		@Override
		public String toString() {
			return "div.panel-body>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)";
		}
	},
	STATS_AVG_FORM{
		@Override
		public String toString() {
			return "div.panel-body>table>tbody>tr:nth-of-type(3)>td:nth-of-type(2)";
		}
	},
	STATS_AVG_AGE{
		@Override
		public String toString() {
			return "div.panel-body>table>tbody>tr:nth-of-type(4)>td:nth-of-type(2)";
		}
	},
	STATS_AVG_VALUE{
		@Override
		public String toString() {
			return "div.panel-body>table>tbody>tr:nth-of-type(5)>td:nth-of-type(2)";
		}
	},
	STATS_SUM_VALUE{
		@Override
		public String toString() {
			return "div.panel-body>table>tbody>tr:nth-of-type(6)>td:nth-of-type(2)";
		}
	},
	PLAYER_STATS{
		@Override
		public String toString() {
			return "table.table.table-condensed.table-skills.small";
		}
	},
	PLAYER_VALUES{
		@Override
		public String toString() {
			return "div.col-md-4.col-sm-8.col-xs-12.small>strong:nth-of-type(1)";
		}
	},
	PLAYER_WAGE{
		@Override
		public String toString() {
			return "div.col-md-4.col-sm-8.col-xs-12.small>strong:nth-of-type(2)";
		}
	},
	PLAYER_FORM{
		@Override
		public String toString() {
			return "div.col-md-4.col-sm-8.col-xs-12.small>strong:nth-of-type(3)";
		}
	},
	PLAYER_STAMINA{
		@Override
		public String toString() {
			return "div.skills.col-md-6.col-sm-8.col-xs-12>table>tbody>tr:nth-of-type(1)>td:nth-of-type(1)";
		}
	},
	PLAYER_PACE{
		@Override
		public String toString() {
			return "div.skills.col-md-6.col-sm-8.col-xs-12>table>tbody>tr:nth-of-type(2)>td:nth-of-type(1)";
		}
	},
	PLAYER_TECHNIQUE{
		@Override
		public String toString() {
			return "div.skills.col-md-6.col-sm-8.col-xs-12>table>tbody>tr:nth-of-type(3)>td:nth-of-type(1)";
		}
	},
	PLAYER_PASSES{
		@Override
		public String toString() {
			return "div.skills.col-md-6.col-sm-8.col-xs-12>table>tbody>tr:nth-of-type(4)>td:nth-of-type(1)";
		}
	},
	PLAYER_KEEPER{
		@Override
		public String toString() {
			return "div.skills.col-md-6.col-sm-8.col-xs-12>table>tbody>tr:nth-of-type(1)>td:nth-of-type(2)";
		}
	},
	PLAYER_DEFENDER{
		@Override
		public String toString() {
			return "div.skills.col-md-6.col-sm-8.col-xs-12>table>tbody>tr:nth-of-type(2)>td:nth-of-type(2)";
		}
	},
	PLAYER_PLAYMAKER{
		@Override
		public String toString() {
			return "div.skills.col-md-6.col-sm-8.col-xs-12>table>tbody>tr:nth-of-type(3)>td:nth-of-type(2)";
		}
	},
	PLAYER_STRIKER{
		@Override
		public String toString() {
			return "div.skills.col-md-6.col-sm-8.col-xs-12>table>tbody>tr:nth-of-type(4)>td:nth-of-type(2)";
		}
	},
	PLAYER_NAME{
		@Override
		public String toString() {
			return "div.h5.title-block-2.text-primary>a";
		}
	},
	PLAYER_AGE{
		@Override
		public String toString() {
			return "div.h5.title-block-2.text-primary";
		}
	}, 
	PLAYER_BMI{
		@Override
		public String toString() {
			return "div.col-md-4.col-sm-8.col-xs-12.small>span>strong";
		}
	},
	PLAYER_HEIGHT{
		@Override
		public String toString() {
			return "div.col-md-4.col-sm-8.col-xs-12.small>strong:nth-of-type(4)";
		}
	},
	PLAYER_WEIGHT{
		@Override
		public String toString() {
			return "div.col-md-4.col-sm-8.col-xs-12.small>strong:nth-of-type(5)";
		}
	}
	
}
