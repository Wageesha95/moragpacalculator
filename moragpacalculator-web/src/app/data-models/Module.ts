import {StudentCategory} from "./studentCategory";

export class Module{
  constructor(
    public id:String,
    public userId:String,
    public studentCategory:StudentCategory,
    public moduleCode:String,
    public moduleName:String,
    public result:number,
    public credit:number,
    public gpa:boolean,
    public elective:boolean,
    public enrollment:boolean
  ) {
  }
}
