import {Semester} from "./Semester";

export class Course {
  constructor(
    public id:String,
    public userId:String,
    public CourseName:String,
    public courseContent:Map<String,Semester>,
  ) {
  }

}
