## Back-End Notes

### Initial Layout
- `CleaningProduct`, `FacilityCleaningProduct`, and `FacilityCleaningProductId` are the models in JPA for other entity relationships.
  - `FacilityCleaningProduct` provides the inventory of a given cleaning product at any facility. Other join tables can be modeled on this class.
  - `FacilityCleaningProductId` provides the composite id for `FacilityCleaningProduct`.
- `Facility` has a mapped relationship to `FacilityCleaningProduct` which can also be modeled as entities progress.
- In `BootPandemicSupply`, the `CleaningProductController` has read functionality for a single `CleaningProduct` found by id and for a single `FacilityCleaningProduct` found by the `Facility`'s id and the `CleaningProduct`'s id. This can be used to model the bones of the other controllers to come.
- The database accessor objects are based out of the `com.pandemicsupply.daos` package. The `CleaningProduct`-based DAO, DAOImpl, and in the `com.pandemicsupply.repositories`, the `CleaningProduct`-related repositories provide the basic database connectivity.


### API Routes

#### Facilities
GET `srsapi/facilities/{fid}` - Single `Facility` by id.  
GET `srsapi/facilities/{fid}/cleaningProducts/{cpid}` - `FacilityCleaningProduct` by facility id and cleaning product id.  
PATCH `srsapi/facilities/{fid}/cleaningProducts/{cpid}/{quantity}` - Update `Facility` inventory by facility id, cleaning product id, quantity. If no `FacilityCleaningProduct` exists, it will be created with this quantity.  

#### Cleaning Products
GET `srsapi/cleaningProducts/{cpid}` - Single `CleaningProduct` by its id.  
POST `srsapi/cleaningProducts` - Create new `CleaningProduct`.  
PATCH `srsapi/cleaningProducts` - Update `CleaningProduct`.  
