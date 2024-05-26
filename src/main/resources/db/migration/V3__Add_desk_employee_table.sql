create table if not exists desk_employee(
    employee_id uuid not null,
    desk_id uuid not null,

    foreign key (desk_id) references desk(id),
    foreign key (employee_id) references employee(id)
)