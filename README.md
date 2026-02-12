# TechBridge

## 1. Project Overview

TechBridge is a Tech Donation Platform that connects businesses with schools to redistribute functional electronic
devices that are no longer required for corporate use but are still suitable for students’ learning needs.

Disadvantaged high school students (and below) can apply for devices through NGOs, social workers, or school
representatives.

The system is designed not only for program coordinators, but also for partnered businesses and schools to submit
requests, manage donations, and track allocation progress through a structured workflow.

---

## 2. Tech Stack

- Spring Boot
- Angular
- MySQL (Docker)
- JWT Authentication
- Maven

---

# 3. Requirements & MVP Plan

## 3.1 Development Order

1. Authentication (JWT)
2. Role authorization
3. Organisation module
4. Request module
5. Donation module
6. Allocation logic
7. Basic dashboard
8. Audit logging

## 3.2 Roles

| Role | Purpose                                                            |
|------|--------------------------------------------------------------------|
| ADMIN | Approves organisations, monitor donation status, allocates devices |
| REQUESTING_ORG | Submits donation requests                                          |
| BUSINESS | Submits devices for donation                                       |
| REFURB_PARTNER (Future) | Updates refurb status                                       |

---

## 3.3 Role-Based Access Control

### ADMIN
- Approve / reject organisations
- Approve / reject requests and donations
- Allocate devices
- View dashboard metrics

### REQUESTING_ORG
- Create & update device requests
- View request status

### BUSINESS
- Submit & update donation offers
- View allocation status

---

# 4. Core Domain Modules
- Authentication
- Role-based access
- Device submission
- Donation request submission
- Manual admin allocation

## 4.1 User accounts feature
- Email registration + verification
- JWT authentication + refresh token
- Password reset (24h expiry)
- Update profile details

## 4.2 Admin
- Overview Metrics
  - Pending requests
  - Approved organisations
  - Available devices
  - Allocations this month
- Search & filter by type/status
- Pagination support

### 4.2.1 Allocation Workflow: 
Admin matches donations → requests.

Basic rules:
- Allocation reduces donation quantity
- Allocation increases fulfilled amount
- Auto-update status when complete

## 4.3 Device Requests by Requesting Orgs
- Create & update request
- Status tracking (Pending for Admin approval -> Fulfilled)

## 4.4 Donation Offers by Business
- Submit donation
- Admin approval
- Status tracking (Pending for Admin approval -> Fulfilled)
- Track remaining quantity

---

# 5. Audit Logging (TBD)

Log meaningful actions:
- Request created / updated
- Donation created / updated
- Organisation approved / rejected
- Allocation performed

---

# 6. Future Enhancements

Dashboard:
- Export table content to Excel
- Email notifications
- PDF generation
- Refurbishment partner workflow

User accounts:
- Two-factor authentication
- Brute-force protection
- Profile image


