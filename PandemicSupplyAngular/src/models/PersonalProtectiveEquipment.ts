export class PersonalProtectiveEquipment {
  id: number;
  name: string;
  improvised: boolean;
  powdered: boolean;
  reusable: boolean;
  size: Size;
  type: string;
  UPC: string;

  constructor(
    id?: number,
    name?: string,
    improvised?: boolean,
    powdered?: boolean,
    reusable?: boolean,
    size?: Size,
    type?: string,
    UPC?: string
  ) {
    this.id = id;
    this.name = name;
    this.improvised = improvised;
    this.powdered = powdered;
    this.reusable = reusable;
    this.size = size;
    this.type = type;
    this.UPC = UPC;
  }
}
