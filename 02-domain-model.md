# TechBridge – Domain Model Specification

This document defines the core entities for the MVP.

# 1. User

Represents a system account.

## Fields

- id (PK)
- first_name
- last_name
- email (unique)
- password
- role (ADMIN | BUSINESS | REQUESTING_ORG)
- account_status (ACTIVE | PENDING | SUSPENDED)
- created_at
- updated_at


# 2. Requesting Org (Schools / NGOs)

## Fields

- id (PK)
- user_id (FK -> User)
- name
- address
- contact_number
- description
- approval_status (PENDING | APPROVED | REJECTED | SUSPENDED?)


# 3. Business (Donor)

## Fields

- id (PK)
- user_id (FK -> User)
- business_name
- abn
- address
- contact_number
- approval_status (PENDING | APPROVED | REJECTED)


# 4. Donation Request

Submitted by a REQUESTING_ORG.

## Fields

- id (PK)
- organisation_id (FK → Organisation)
- device_type
- min_ram
- min_storage
- quantity_requested
- notes (for justification_text?)
- status (PENDING | APPROVED | PARTIALLY_FULFILLED | COMPLETED | REJECTED)
- created_at
- updated_at


# 5. Device (Donation Listing)

Submitted by a BUSINESS.

## Fields

- id (PK)
- business_id (FK → Business)
- device_type (LAPTOP | DESKTOP | TABLET)
- brand
- model
- spec_cpu
- spec_ram
- spec_storage
- condition (WORKING | NEEDS_REPAIR)
- quantity
- status (SUBMITTED | APPROVED | ALLOCATED | REFURBISHED | COMPLETED)
- created_at
- updated_at


# 5. Allocation (Core Business Logic)

Represents a match between a Donated Device and a Organisation Request.

## Fields

- id (PK)
- device_id (FK -> Device)
- request_id (FK -> DonationRequest)
- quantity_allocated
- allocated_by (FK -> ADMIN)
- allocated_at


# 6. AuditLog (Later)

Tracks important domain actions.

## Fields

- id (PK)
- user_id
- action_type (DEVICE_APPROVED, REQUEST_REJECTED, ALLOCATION_CREATED)
- entity_type
- entity_id
- timestamp


# 7. Key Relationships

- One Organisation -> Many Users
- One Organisation -> Many DeviceRequests
- One Organisation -> Many Donations
- One Donation -> Many Allocations
- One DeviceRequest -> Many Allocations
- One User -> Many AuditLogs