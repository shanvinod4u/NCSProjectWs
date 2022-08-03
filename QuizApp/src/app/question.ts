export class Question {
    questionId:number;
    questionString:string;
    category:string;
    difficulty:number;
    option1:string;
    option2:string;
    option3:string;
    option4:string;
    correctAnswer:string;
    givenAnswer:string;

    constructor(
        questionId:number,
        questionString:string,
        category:string,
        difficulty:number,
        option1:string,
        option2:string,
        option3:string,
        option4:string,
        correctAnswer:string,
        givenAnswer:string
        
    ) {
        this.questionId = questionId;
        this.questionString =questionString;
        this.category = category;
        this.difficulty =difficulty;
        this.option1 = option1;
        this.option2 =option2;
        this.option3 =option3;
        this.option4 =option4;
        this.correctAnswer =correctAnswer;
        this.givenAnswer = givenAnswer;
    }
}
