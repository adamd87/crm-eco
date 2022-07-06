import { Address } from "./address";
import { Client } from "./client";

export interface ClientDetailsDto{
    client: Client;
    addresses: Address[];
}