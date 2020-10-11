import {StudentCategory} from "./studentCategory";
import {Course} from "./Course";
import {UserProfile} from "./UserProfile";

export class Student {
  constructor(
    public id:String,
    public userProfile:UserProfile,
    public studentCategory:StudentCategory,
    public course:Course
  ) {
  }
}
