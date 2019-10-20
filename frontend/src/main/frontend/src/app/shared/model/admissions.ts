import { Category } from './category';
import { Patient } from './patient';

export class Admissions{

    id: number;
    dateAdmission: Date;
    category: Category;
    patient: Patient;
    externalID: string;

}