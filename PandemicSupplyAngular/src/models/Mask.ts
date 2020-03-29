import {FacilityMask} from './FacilityMask';

export class Mask {
  id: number;
  improvised: boolean;
  name: string;
  rating: string;
  reusable: boolean;
  type: string;
  UPC: string;
  masks: FacilityMask;

  constructor(
    id?: number,
    improvised?: boolean,
    name?: string,
    rating?: string,
    reusable?: boolean,
    type?: string,
    UPC?: string,
    masks?: FacilityMask
  ) {
      this.id = id;
      this.improvised = improvised;
      this.name = name;
      this.rating = rating;
      this.reusable = reusable;
      this.type = type;
      this.UPC = UPC;
      this.masks = masks;
  }

}
