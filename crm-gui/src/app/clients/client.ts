export interface Client {
    id?: number;
    name: string;
    surname: string;
    phone: string;
    email: string;
    info: string;
    agreement: boolean;
    installation: boolean;
    privatePerson: boolean;
    business: boolean;
    nip: string;
    regon: string;
    traderName: string;
}