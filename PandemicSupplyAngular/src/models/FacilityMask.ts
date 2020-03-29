import {FacilityMaskId} from './FacilityMaskId';
import {Facility} from './Facility';
import {Mask} from './Mask';

export class FacilityMask {
  id: FacilityMaskId;
  quantity: number;
  facility: Facility;
  mask: Mask;

  constructor(
    id?: FacilityMaskId,
    quantity?: number,
    facility?: Facility,
    mask?: Mask
  ) {
    this.id = id;
    this.quantity = quantity;
    this.facility = facility;
    this.mask = mask;
  }

}
