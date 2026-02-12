# TechBridge – Domain Model Specification

This document defines the core entities for the MVP.

# User
Represents a system account.

- id (PK)
- first_name
- last_name
- email (unique)
- password
- enabled (to show if the user is active)
- non_locked (to show if the user is suspended)
- created_at

# Role
- id (PK)
- name (unique) (to show e.g. admin, business, requesting orgs)
- permission (e.g. read, update, etc.)


# Requesting Org (Schools / NGOs)
- id (PK)
- user_id (FK -> User)
- name
- address
- contact_number
- description


# Business (Donor)
- id (PK)
- user_id (FK -> User)
- business_name
- abn
- address
- contact_number


# Donation Request
Submitted by a REQUESTING_ORG.

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


# Device (Donation Listing)
Submitted by a BUSINESS.

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


# Allocation (Core Business Logic)
Represents a match between a Donated Device and a Organisation Request.

- id (PK)
- device_id (FK -> Device)
- request_id (FK -> DonationRequest)
- quantity_allocated
- allocated_by (FK -> ADMIN)
- allocated_at


# AuditLog
Tracks important domain actions.

User performed Event on Entity:
- User -> who
- Event -> what action
- Entity -> which record

Included in the UserEvents table.


# Key Relationships
- One Organisation -> Many Users
- One Organisation -> Many DeviceRequests
- One Organisation -> Many Donations
- One Donation -> Many Allocations
- One DeviceRequest -> Many Allocations
- One User -> Many AuditLogs