package h03;

//interface to create each of the statements used 
public interface Programmer {
	// creating objects for each class
	Assignment makeAssignment();

	MethodCall makeMethodCall();

	WhileLoop makeWhileLoop();

	Conditional makeConditional();

	Statement makeStatement();
}
