export class ModuleDefinition {
    constructor(
        public id: string,
        public moduleCode: string,
        public moduleName: string,
        public result:null,
        public moduleCredits: number,
        public gpa: boolean,
        public elective: boolean
    ) { }
}
