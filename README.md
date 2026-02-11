# TechBridge

## 1. Project Overview

TechBridge is a Tech Donation Platform that connects businesses with schools to redistribute functional electronic 
devices that are no longer required for corporate use but are still suitable for students’ learning needs.

Disadvantaged high school students (and below) can apply for devices through NGOs, social workers, or school 
representatives.

The system is designed not only for program coordinators, but also for partnered businesses and schools to submit 
requests, manage donations, and track allocation progress through a structured workflow.

### Tech stack

- Spring Boot
- Angular

# 2. Requirements Mapping & MVP Plan

## 2.1 Roles

| Role | Description |
|------|------------|
| ADMIN | Program coordinator managing approvals and allocations |
| REQUESTING_ORG | NGOs, social workers, or school representatives submitting device requests |
| BUSINESS | Business donating devices |
| REFURB_PARTNER (Future) | Partner updating refurbishment status |


## 2.2 User Account Features

### Required for MVP

- Unique email registration
- Email verification
- Login with JWT authentication
- Refresh token support
- Password reset (token expires in 24 hours)
- Update profile details:
    - Name
    - Email
    - Phone
    - Organisation Name
    - Address

### Optional (Future Enhancements)

- Profile image
- Two-factor authentication
- Brute-force login protection

## 2.3 Role-Based Access Control (ACL)

Application resources must be protected based on roles:

- ADMIN
    - Approve / reject requesting orgs
    - Approve / reject donations
    - Allocate devices
    - View dashboard statistics

- REQUESTING_ORG
    - Submit device requests
    - View request status
    - Update request details

- BUSINESS
    - Submit donation offers
    - Update donation details
    - View allocation status

# 3. Organisations

## 3.1 Organisation Entity

### Fields:

- id
- name
- type (REQUESTING_ORG | BUSINESS)
- address
- contactEmail
- contactPhone
- status (PENDING | APPROVED | REJECTED | ACTIVE | SUSPENDED)
- createdAt
- updatedAt

## 3.2 Organisation Features

- Search by name
- Pagination support
- Filter by type
- Filter by status
- Export to spreadsheet (Future enhancement)


# 4. Device Requests

## 4.1 Device Request (REQUESTING_ORG)

### Fields:

- id
- requestingOrgId
- deviceType
- quantity
- minimumSpecs
- priorityLevel
- status (PENDING | APPROVED | REJECTED | PARTIALLY_FULFILLED | FULFILLED)
- createdAt
- updatedAt

### Features:

- Create request
- Update request
- View request status
- Admin approval workflow
- Allocation tracking

# 5. Donation Offers

## 5.1 Donation Entity

### Fields:

- id
- businessId
- deviceType
- quantity
- condition
- pickupLocation
- status (PENDING | APPROVED | ALLOCATED)
- createdAt
- updatedAt

### Features:

- Submit donation
- Update donation quantity
- Admin approval
- Allocation to requesting orgs
- Mark as completed


# 6. Allocation Workflow

Admin can:

- View pending requests
- View available donations
- Allocate devices from donation → to request
- Update statuses accordingly

### Allocation Rules (Basic Version)

- Allocation reduces donation quantity
- Allocation increases fulfilled count of request
- If request quantity met → mark FULFILLED
- If donation quantity exhausted → mark ALLOCATED

# 7. Audit Logging

E.g. log meaningful domain actions:

### Logged Events

- Requesting orgs submit request
- Requesting orgs update request
- Business submits donation
- Business updates donation
- Admin approves/rejects organisation
- Admin approves/rejects request
- Admin allocates devices

### Audit Log Fields

- id
- userId
- actionType
- entityType
- entityId
- timestamp
- details


# 8. Admin Dashboard

## Overview Widgets

- Total pending requests
- Total approved requesting orgs
- Total available devices
- Devices allocated this month
- Organisations awaiting approval

## Tables on screens

### Requesting Orgs

| Requesting Orgs | Status | Devices Requested | Fulfilled | Remaining |

### Businesses

| Business | Status | Devices Donated | Allocated | Remaining |


# 9. MVP Development Order

Build in this order:

1. User Registration + JWT Authentication
2. Role-Based Authorization
3. Organisation Entity
4. Device Request Entity
5. Donation Entity
6. Admin Approval Workflow
7. Allocation Logic
8. Basic Admin Dashboard


# 10. Features to Skip for MVP

Later:

- Two-factor authentication
- Complex brute-force protection
- PDF generation
- Email notifications
- Refurbishment Partners and the Device refurbishment workflow