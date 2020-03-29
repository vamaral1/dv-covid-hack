import {FacilityPPEId} from './FacilityPPEId';
import {PersonalProtectiveEquipment} from './PersonalProtectiveEquipment';
import {Facility} from './Facility';

export class FacilityPPE {

  id: FacilityPPEId;
  quantity: number;
  ppe: PersonalProtectiveEquipment;
  facility: Facility;

  constructor(
    id?: FacilityPPEId,
    quantity?: number,
    ppe?: PersonalProtectiveEquipment,
    facility?: Facility
  ) {
    this.id = id;
    this.quantity = quantity;
    this.ppe = ppe;
    this.facility = facility;

  }

}
