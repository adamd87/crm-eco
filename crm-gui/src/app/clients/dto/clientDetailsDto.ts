import { Address } from "./address";
import { Client } from "./client";

export class ClientDetailsDto{
    client?: Client;
    addresses?: Address[];
}