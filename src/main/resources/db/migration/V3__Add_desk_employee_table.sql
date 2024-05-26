create table if not exists desk_employee(
    id uuid primary key,
    employee_id uuid not null,
    desk_id uuid not null,

    foreign key (desk_id) references desk(id),
    foreign key (employee_id) references employee(id)
)