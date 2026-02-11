# TechBridge – Domain Model Specification

This document defines the core entities for the MVP.

---

# 1. User

Represents a system account.

## Fields

- id (UUID)
- email (unique)
- password
- role (ADMIN | REQUESTING_ORG | BUSINESS)
- firstName
- lastName
- phone
- organisationId (nullable for ADMIN)
- enabled (boolean)
- createdAt
- updatedAt

---

# 2. Organisation

Represents a requesting organisation or donating business.

## Fields

- id (UUID)
- name
- type (REQUESTING_ORG | BUSINESS)
- address
- contactEmail
- contactPhone
- status (PENDING | APPROVED | REJECTED | ACTIVE | SUSPENDED)
- createdAt
- updatedAt

---

# 3. DeviceRequest

Submitted by a REQUESTING_ORG.

## Fields

- id (UUID)
- organisationId
- deviceType
- quantityRequested
- quantityFulfilled (default: 0)
- minimumSpecs
- priorityLevel
- status (PENDING | APPROVED | REJECTED | PARTIALLY_FULFILLED | FULFILLED)
- createdAt
- updatedAt

---

# 4. Donation

Submitted by a BUSINESS.

## Fields

- id (UUID)
- organisationId
- deviceType
- quantityTotal
- quantityRemaining
- condition
- pickupLocation
- status (PENDING | APPROVED | ALLOCATED | COMPLETED)
- createdAt
- updatedAt

---

# 5. Allocation

Represents a match between a Donation and a DeviceRequest.

## Fields

- id (UUID)
- donationId
- requestId
- quantityAllocated
- allocatedBy (ADMIN userId)
- createdAt

---

# 6. AuditLog

Tracks important domain actions.

## Fields

- id (UUID)
- userId
- actionType
- entityType
- entityId
- details (JSON or text)
- createdAt

---

# 7. Key Relationships

- One Organisation → Many Users
- One Organisation → Many DeviceRequests
- One Organisation → Many Donations
- One Donation → Many Allocations
- One DeviceRequest → Many Allocations
- One User → Many AuditLogs