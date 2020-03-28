import {Facility} from './Facility';
import {CleaningProduct} from './CleaningProduct';
import {FacilityCleaningProductId} from './FacilityCleaningProductId';

export class FacilityCleaningProduct {
  id: FacilityCleaningProductId;
  quantity: number;
  facility: Facility;
  cleaningProduct: CleaningProduct;

  constructor(
    id?: FacilityCleaningProductId,
    quantity?: number,
    facility?: Facility,
    cleaningProduct?: CleaningProduct
  ) {
    this.id = id;
    this.quantity = quantity;
    this.facility = facility;
    this.cleaningProduct = cleaningProduct;
  }
}
