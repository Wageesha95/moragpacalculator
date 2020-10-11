import {StudentCategory} from "./studentCategory";
import {Module} from "./Module";

export class Semester{


  constructor(
    public id :String,
    public userId:String,
    public studentCategory:StudentCategory,
    public semesterNo:String,
    public semesterModule:Module[],
    public semesterGPA:number,
    public cumulativeGPA:number
  ) {
  }
}
