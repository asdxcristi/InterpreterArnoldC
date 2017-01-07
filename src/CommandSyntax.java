/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea sintaxei comenzilor limbajului.Pentru acces la sintaxa
 *         implicitita,use toString()
 */
public enum CommandSyntax {

	BEGIN_MAIN {
		public String toString() {
			return "IT'S SHOWTIME";
		}
	},
	END_MAIN {
		public String toString() {
			return "YOU HAVE BEEN TERMINATED";
		}
	},
	FALSE {
		public String toString() {
			return "I LIED";
		}
	},
	TRUE {
		public String toString() {
			return "NO PROBLEMO";
		}
	},

	IF {
		public String toString() {
			return "BECAUSE I'M GOING TO SAY PLEASE";
		}
	},
	ELSE {
		public String toString() {
			return "BULLSHIT";
		}
	},
	END_IF {
		public String toString() {
			return "YOU HAVE NO RESPECT FOR LOGIC";
		}
	},

	WHILE {
		public String toString() {
			return "STICK AROUND";
		}
	},
	END_WHILE {
		public String toString() {
			return "CHILL";
		}
	},

	PLUS_OPERATOR {
		public String toString() {
			return "GET UP";
		}
	},
	MINUS_OPERATOR {
		public String toString() {
			return "GET DOWN";
		}
	},
	MULTIPLICATION_OPERATOR {
		public String toString() {
			return "YOU'RE FIRED";
		}
	},
	DIVISION_OPERATOR {
		public String toString() {
			return "HE HAD TO SPLIT";
		}
	},
	MODULO_OPERATOR {
		public String toString() {
			return "I LET HIM GO";
		}
	},

	EQUAL_TO {
		public String toString() {
			return "YOU ARE NOT YOU YOU ARE ME";
		}
	},
	GREATER_THAN {
		public String toString() {
			return "LET OFF SOME STEAM BENNET";
		}
	},

	OR {
		public String toString() {
			return "CONSIDER THAT A DIVORCE";
		}
	},
	AND {
		public String toString() {
			return "KNOCK KNOCK";
		}
	},

	DECLARE_INT {
		public String toString() {
			return "HEY CHRISTMAS TREE";
		}
	},
	SET_INITIAL_VALUE {
		public String toString() {
			return "YOU SET US UP";
		}
	},

	PRINT {
		public String toString() {
			return "TALK TO THE HAND";
		}
	},

	ASSIGN_VARIABLE {
		public String toString() {
			return "GET TO THE CHOPPER";
		}
	},
	SET_VALUE {
		public String toString() {
			return "HERE IS MY INVITATION";
		}
	},
	END_ASSIGN_VARIABLE {
		public String toString() {
			return "ENOUGH TALK";
		}
	}

}
