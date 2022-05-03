import { Address } from "./address";

export class Client {
    id?: number;
    name?: string;
    surname?: string;
    phone?: string;
    email?: string;
    info?: string;
    addressesList: Address[] = [];
    agreement?: boolean;
    installation?: boolean;
    privatePerson?: boolean;
    business?: boolean;
    nip?: string;
    regon?: string;
    traderName?: string;
}
