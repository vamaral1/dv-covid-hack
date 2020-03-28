import {FacilityCleaningProduct} from './FacilityCleaningProduct';
import {FacilityMask} from './FacilityMask';

export class Facility {
  id: number;
  address: number;
  name: string;
  facilityCleaningProducts: FacilityCleaningProduct[];
  masks: FacilityMask;

  constructor(
    id?: number,
    address?: number,
    name?: string,
    facilityCleaningProducts?: FacilityCleaningProduct[],
    masks?: FacilityMask
  ) {
    this.id = id;
    this.address = address;
    this.name = name;
    this.facilityCleaningProducts = facilityCleaningProducts;
    this.masks = masks;
  }
}
