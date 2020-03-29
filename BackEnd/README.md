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
PATCH `srsapi/facilities` - Update existing facility.  
POST `srsapi/facilities` - Create new `Facility`.  

#### Cleaning Products
GET `srsapi/cleaningProducts/{cpid}` - Single `CleaningProduct` by its id.  
POST `srsapi/cleaningProducts` - Create new `CleaningProduct`.  
PATCH `srsapi/cleaningProducts` - Update `CleaningProduct`.  

#### Facility Cleaning Product Inventory  
GET `srsapi/facilities/{fid}/cleaningProducts/{cpid}` - `FacilityCleaningProduct` by facility id and cleaning product id.    
GET `srsapi/facilities/cleaningProducts/{cpid}` - Find all `FacilityCleaningProduct`s associated with a `CleaningProduct`.    
PATCH `srsapi/facilities/{fid}/cleaningProducts/{cpid}/{quantity}` - Update `Facility` inventory by facility id, cleaning product id, quantity. If no `FacilityCleaningProduct` exists, it will be created with this quantity.

#### Masks
GET `srsapi/masks/{mid}` - Get `Mask` by id.  
POST `srsapi/masks` - Create new `Mask`.  
PATCH `srsapi/masks` - Update `Mask`.  

#### Facility Mask Inventory  
GET `srsapi/facilities/{fid}/masks/{mid}` - `FacilityMask` by facility id and mask id.    
GET `srsapi/facilities/masks/{mid}` - Find all `FacilityMask`s associated with a `Mask`.    
PATCH `srsapi/facilities/{fid}/masks/{mid}/{quantity}` - Update `Facility` inventory by facility id, mask id, and quantity. If no `FacilityMask` exists, it will be created with this quantity.

#### PPE  
GET `srsapi/ppe/{ppeId}` - Get `PersonalProtectiveEquipment` by id.  
POST `srsapi/ppe` - Create new `PersonalProtectiveEquipment`.  
PATCH `srsapi/ppe` - Update `PersonalProtectiveEquipment`.   

#### Facility PPE Inventory  
GET `srsapi/facilities/{fid}/ppe/{ppeId}` - `FacilityPPE` by facility id and ppe id.    
GET `srsapi/facilities/ppe/{ppeId}` - Find all `FacilityPPE`s associated with a `PersonalProtectiveEquipment`.    
PATCH `srsapi/facilities/{fid}/ppe/{ppeId}/{quantity}` - Update `Facility` inventory by facility id, ppe id, and quantity. If no `FacilityPPE` exists, it will be created with this quantity.  

#### Room  
GET `srsapi/rooms/{rid}` - Get `Room` by id.  
POST `srsapi/rooms` - Create new `Room`.  
PATCH `srsapi/rooms` - Update `Room`.   

#### Facility Room Inventory  
GET `srsapi/facilities/{fid}/rooms/{rid}` - `FacilityRoom` by facility id and room id.    
GET `srsapi/facilities/rooms/{rid}` - Find all `FacilityRoom`s associated with a `Room`.    
PATCH `srsapi/facilities/{fid}/rooms/{rid}/{quantity}` - Update `Facility` inventory by facility id, room id, and quantity. If no `FacilityRoom` exists, it will be created with this quantity.
