export class UpdateAddressReq{
    id?: number;
    clientId?: number;
    street?: string;
    buildingNumber?: string;
    apartmentNumber?: string;
    postCode?: string;
    city?: string;
    country?: string;
    ofCorrespondence?: boolean;
    ofOrder?: boolean;
    headquarters?: boolean;
}