export class CleaningProduct {
  id: number;
  agent: string;
  concentration: number;
  name: string;
  volume: number;
  UPC: string;

  constructor(
    id?: number,
    agent?: string,
    concentration?: number,
    name?: string,
    volume?: number,
    UPC?: string
  ) {
    this.id = id;
    this.agent = agent;
    this.concentration = concentration;
    this.name = name;
    this.volume = volume;
    this.UPC = UPC;
  }
}
