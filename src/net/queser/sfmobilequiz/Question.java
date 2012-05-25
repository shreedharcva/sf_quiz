package net.queser.sfmobilequiz;

public class Question {
	public class Option {
		public String OptionId;
		public String Text;
		public Boolean isRight;
	}

	private String Id;
	private Option[] Options;
	
	
	public Question(String Id) {
		this.Id = Id;
	}
	public void setOptions(Question.Option[] options) {
		this.Options = options;
	}
}
