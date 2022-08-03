export class TestScore {
    testId:number;
    date:string;
	category:string;
	level:string;
	totalScore:number;
    marks:number;
    
    constructor(
        testId:number,
        date:string,
        category:string,
        level:string,
        totalScore:number,
        marks:number  
    ){
        this.testId=testId;
        this.date=date;
        this.category=category;
        this.level=level;
        this.totalScore=totalScore;
        this.marks=marks;
    }
}
