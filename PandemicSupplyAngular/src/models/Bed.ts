export class Bed {
  id: number;
  icu: boolean;
  type: string;

  constructor(
    id?: number,
    icu?: boolean,
    type?: string
  ) {
    this.id = id;
    this.icu = icu;
    this.type = type;
  }
}
