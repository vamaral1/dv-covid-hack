export class FacilityCleaningProductId {
  facilityId: number;
  cleaningProductId: number;

  constructor(
    facilityId?: number,
    cleaningProductId?: number
  ) {
    this.facilityId = facilityId;
    this.cleaningProductId = cleaningProductId;
  }
}
