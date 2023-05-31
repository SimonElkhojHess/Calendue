/* Test data for project table */
INSERT INTO `calendue`.`project` (`project_name`, `project_description`, `project_start`, `project_deadline`, `project_status`)
VALUES
    ('Website Redesign', 'Redesign company website for improved user experience', '01/05/2023', '15/06/2023', 'In Progress'),
    ('Marketing Campaign', 'Launch new marketing campaign to target a wider audience', '01/06/2023', '31/07/2023', 'Done'),
    ('Product Development', 'Develop a new product line for increased market share', '15/05/2023', '15/07/2023', 'In Progress'),
    ('Customer Support Enhancement', 'Implement a new ticketing system for improved customer support', '15/06/2023', '31/08/2023', 'To Do'),
    ('Sales Training Program', 'Organize sales training program to enhance team skills', '01/07/2023', '30/09/2023', 'Paused'),
    ('Inventory Management System', 'Build a new system to streamline inventory management', '20/05/2023', '30/06/2023', 'In Progress'),
    ('Social Media Strategy', 'Develop a comprehensive strategy for social media presence', '10/06/2023', '15/08/2023', 'Done'),
    ('Quality Assurance Audit', 'Conduct a thorough audit of quality assurance processes', '15/07/2023', '15/09/2023', 'In Progress'),
    ('Employee Training Program', 'Implement a training program to enhance employee skills', '05/05/2023', '30/06/2023', 'To Do'),
    ('Partnership Expansion', 'Explore new partnership opportunities for business expansion', '20/06/2023', '31/08/2023', 'Paused'),
    ('Website Redesign', 'Redesign company website for improved user experience', '01/05/2023', '15/06/2023', 'In Progress'),
    ('Marketing Campaign', 'Launch new marketing campaign to target a wider audience', '01/06/2023', '31/07/2023', 'Done'),
    ('Product Development', 'Develop a new product line for increased market share', '15/05/2023', '15/07/2023', 'In Progress'),
    ('Customer Support Enhancement', 'Implement a new ticketing system for improved customer support', '15/06/2023', '31/08/2023', 'To Do'),
    ('Sales Training Program', 'Organize sales training program to enhance team skills', '01/07/2023', '30/09/2023', 'Paused'),
    ('Inventory Management System', 'Build a new system to streamline inventory management', '20/05/2023', '30/06/2023', 'In Progress'),
    ('Social Media Strategy', 'Develop a comprehensive strategy for social media presence', '10/06/2023', '15/08/2023', 'Done'),
    ('Quality Assurance Audit', 'Conduct a thorough audit of quality assurance processes', '15/07/2023', '15/09/2023', 'In Progress'),
    ('Employee Training Program', 'Implement a training program to enhance employee skills', '05/05/2023', '30/06/2023', 'To Do'),
    ('Partnership Expansion', 'Explore new partnership opportunities for business expansion', '20/06/2023', '31/08/2023', 'Paused');


/* Test data for subproject table */
INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (1, 'Design Wireframes', 'Create wireframes for the website redesign', '20/04/2023', 'In Progress'),
                                                                                                                                                (1, 'Develop UI Mockups', 'Design UI mockups for the new website', '25/04/2023', 'In Progress'),
                                                                                                                                                (1, 'Backend Development', 'Implement backend functionality for the website', '30/04/2023', 'Done'),
                                                                                                                                                (1, 'Frontend Development', 'Develop frontend components for the website', '02/05/2023', 'In Progress'),
                                                                                                                                                (1, 'Testing and QA', 'Perform testing and quality assurance checks', '05/05/2023', 'Paused'),
                                                                                                                                                (1, 'Deployment and Launch', 'Deploy the redesigned website and launch it', '10/05/2023', 'To Do'),
                                                                                                                                                (1, 'User Feedback Analysis', 'Analyze user feedback for improvements', '15/05/2023', 'To Do'),
                                                                                                                                                (1, 'Performance Optimization', 'Optimize website performance for better user experience', '20/05/2023', 'To Do'),
                                                                                                                                                (1, 'Content Creation', 'Create engaging content for the new website', '25/05/2023', 'To Do'),
                                                                                                                                                (1, 'Final Review and Closure', 'Perform final review and close the project', '30/05/2023', 'To Do');

INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (2, 'Market Research', 'Conduct market research for the new campaign', '15/06/2023', 'Paused'),
                                                                                                                                                (2, 'Content Creation', 'Create compelling content for the campaign', '20/06/2023', 'In Progress'),
                                                                                                                                                (2, 'Design Marketing Materials', 'Design brochures and banners for the campaign', '25/06/2023', 'Done'),
                                                                                                                                                (2, 'Campaign Launch', 'Execute the marketing campaign launch', '30/06/2023', 'To Do');

INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (3, 'Product Concept Development', 'Brainstorm and develop product concepts', '20/05/2023', 'Done'),
                                                                                                                                                (3, 'Prototype Creation', 'Build prototypes for selected product concepts', '25/05/2023', 'Paused'),
                                                                                                                                                (3, 'Testing and Refinement', 'Conduct testing and refine the product', '30/05/2023', 'In Progress'),
                                                                                                                                                (3, 'Production and Manufacturing', 'Start production and manufacturing process', '05/06/2023', 'To Do');

INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (4, 'Requirements Gathering', 'Gather requirements for the ticketing system', '25/06/2023', 'In Progress'),
                                                                                                                                                (4, 'System Design', 'Design the architecture of the ticketing system', '30/06/2023', 'Paused'),
                                                                                                                                                (4, 'Development and Testing', 'Develop and test the ticketing system', '05/07/2023', 'To Do');

INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (5, 'Training Material Preparation', 'Prepare training materials for the program', '15/07/2023', 'Paused'),
                                                                                                                                                (5, 'Training Session Planning', 'Plan and schedule training sessions', '20/07/2023', 'To Do'),
                                                                                                                                                (5, 'Training Session Execution', 'Conduct training sessions for employees', '25/07/2023', 'In Progress'),
                                                                                                                                                (5, 'Feedback Collection', 'Collect feedback from participants', '30/07/2023', 'In Progress'),
                                                                                                                                                (5, 'Evaluation and Analysis', 'Evaluate training program effectiveness', '05/08/2023', 'To Do');


INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (6, 'Market Analysis', 'Conduct market analysis for new product', '10/07/2023', 'In Progress'),
                                                                                                                                                (6, 'Product Design', 'Design the new product', '15/07/2023', 'Done'),
                                                                                                                                                (6, 'Prototype Development', 'Develop a prototype of the new product', '20/07/2023', 'Done'),
                                                                                                                                                (6, 'Testing and Refinement', 'Conduct testing and refine the product', '25/07/2023', 'In Progress'),
                                                                                                                                                (6, 'Production Planning', 'Plan the production process', '30/07/2023', 'In Progress'),
                                                                                                                                                (6, 'Marketing and Launch', 'Develop marketing strategy and launch the product', '05/08/2023', 'To Do');

INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (7, 'Social Media Analysis', 'Analyze social media presence and engagement', '20/07/2023', 'Paused'),
                                                                                                                                                (7, 'Content Creation', 'Create engaging content for social media', '25/07/2023', 'In Progress'),
                                                                                                                                                (7, 'Campaign Execution', 'Execute social media campaign', '30/07/2023', 'Done');

INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (8, 'Audit Planning', 'Plan the quality assurance audit process', '15/08/2023', 'To Do'),
                                                                                                                                                (8, 'Data Collection', 'Collect data for the audit', '20/08/2023', 'To Do');

INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (9, 'Training Needs Assessment', 'Assess training needs of employees', '10/07/2023', 'In Progress'),
                                                                                                                                                (9, 'Training Program Development', 'Develop training program curriculum', '15/07/2023', 'Done'),
                                                                                                                                                (9, 'Training Material Preparation', 'Prepare training materials', '20/07/2023', 'Done');

INSERT INTO `calendue`.`subproject` (`project_id`, `subproject_name`, `subproject_description`, `subproject_deadline`, `subproject_status`) VALUES
                                                                                                                                                (10, 'Partnership Research', 'Conduct research on potential partnership opportunities', '25/08/2023', 'In Progress'),
                                                                                                                                                (10, 'Negotiation and Agreements', 'Negotiate partnership terms and agreements', '30/08/2023', 'In Progress'),
                                                                                                                                                (10, 'Partnership Implementation', 'Implement the partnership', '05/09/2023', 'To Do');


/* Test data for task table*/
INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (1, 'Wireframe Design for Homepage', 'Complete wireframe design for the homepage', 'Additional feedback required', '10/05/2023', 8, 5, 'In Progress'),
                                                                                                                                                                    (1, 'Wireframe Design for Product Listing Page', 'Review and finalize wireframes for the product listing page', '', '12/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (1, 'Wireframe Design for User Registration Process', 'Create wireframes for the user registration process', '', '15/05/2023', 4, 1, 'Done'),
                                                                                                                                                                    (1, 'Presentation of Wireframe Designs', 'Present wireframe designs to the team', '', '18/05/2023', 2, 5, 'Done'),
                                                                                                                                                                    (1, 'UX Research and Analysis', 'Conduct user research and analyze findings', 'Refer to the UX research plan', '20/05/2023', 8, 1, 'In Progress');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (2, 'UI Mockup Design for Homepage', 'Design UI mockups for the homepage', 'Review with the design team', '12/05/2023', 6, 3, 'In Progress'),
                                                                                                                                                                    (2, 'UI Mockup Design for Product Listing Page', 'Create UI mockups for the product listing page', '', '15/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (2, 'UI Mockup Design for User Registration Process', 'Design UI mockups for the user registration process', '', '18/05/2023', 2, 5, 'To Do'),
                                                                                                                                                                    (2, 'Review and Finalize UI Mockups', 'Review and finalize UI mockups with stakeholders', '', '20/05/2023', 4, 2, 'To Do'),
                                                                                                                                                                    (2, 'Frontend Development for Homepage', 'Develop frontend components for the homepage', '', '22/05/2023', 8, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (3, 'Backend Implementation', 'Implement backend functionality for the website', 'Integration with the database', '15/05/2023', 10, 1, 'In Progress'),
                                                                                                                                                                    (3, 'Frontend Development for Product Listing Page', 'Develop frontend components for the product listing page', '', '20/05/2023', 6, 2, 'To Do'),
                                                                                                                                                                    (3, 'Frontend Development for User Registration Process', 'Develop frontend components for the user registration process', '', '23/05/2023', 6, 3, 'To Do'),
                                                                                                                                                                    (3, 'Unit Testing', 'Perform unit testing for implemented functionality', '', '25/05/2023', 4, 5, 'To Do'),
                                                                                                                                                                    (3, 'Integration Testing', 'Perform integration testing for the implemented functionality', '', '28/05/2023', 6, 4, 'To Do'),
                                                                                                                                                                    (3, 'Documentation', 'Prepare documentation for the implemented functionality', '', '30/05/2023', 4, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (4, 'Database Design and Setup', 'Design and set up the database structure', 'Refer to the project requirements', '18/05/2023', 6, 3, 'Done'),
                                                                                                                                                                    (4, 'Backend API Development', 'Develop backend APIs for data manipulation', '', '22/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (4, 'Integration Testing', 'Perform integration testing for the implemented APIs', '', '25/05/2023', 4, 5, 'Done'),
                                                                                                                                                                    (4, 'Documentation', 'Prepare documentation for the implemented functionalities', '', '28/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (4, 'Security Audit', 'Conduct a security audit of the implemented functionalities', '', '30/05/2023', 6, 3, 'To Do'),
                                                                                                                                                                    (4, 'Performance Testing', 'Perform performance testing of the implemented functionalities', '', '02/06/2023', 6, 4, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (5, 'Backend API Development', 'Develop backend APIs for data retrieval', '', '15/05/2023', 6, 3, 'Done'),
                                                                                                                                                                    (5, 'Frontend Development for Homepage', 'Develop frontend components for the homepage', '', '18/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (5, 'Frontend Development for Product Details Page', 'Develop frontend components for the product details page', '', '22/05/2023', 6, 2, 'Done'),
                                                                                                                                                                    (5, 'Integration Testing', 'Perform integration testing for the implemented functionality', '', '25/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (5, 'Documentation', 'Prepare documentation for the implemented functionality', '', '28/05/2023', 4, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (6, 'Database Design and Setup', 'Design and set up the database structure', 'Refer to the project requirements', '18/05/2023', 6, 3, 'To Do'),
                                                                                                                                                                    (6, 'Backend Development', 'Implement backend functionality for the website', '', '22/05/2023', 8, 1, 'To Do'),
                                                                                                                                                                    (6, 'Frontend Development', 'Develop frontend components for the website', '', '25/05/2023', 6, 2, 'To Do'),
                                                                                                                                                                    (6, 'Unit Testing', 'Perform unit testing for implemented functionality', '', '28/05/2023', 4, 5, 'To Do'),
                                                                                                                                                                    (6, 'Deployment', 'Deploy the website to production server', '', '30/05/2023', 4, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (7, 'Requirement Gathering', 'Gather requirements from stakeholders', 'Schedule meetings with stakeholders', '20/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (7, 'System Design', 'Design the overall system architecture', '', '25/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (7, 'Backend Development', 'Implement backend functionality based on requirements', '', '28/05/2023', 6, 2, 'To Do'),
                                                                                                                                                                    (7, 'Frontend Development', 'Develop frontend components based on requirements', '', '30/05/2023', 6, 2, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (8, 'Market Research', 'Conduct market research to identify target audience', 'Analyze market trends and competitors', '22/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (8, 'Marketing Strategy Planning', 'Develop a marketing strategy for the product', '', '25/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (8, 'Campaign Execution', 'Execute marketing campaigns as per the strategy', '', '28/05/2023', 6, 3, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (9, 'Content Creation', 'Create engaging content for the website', 'Collaborate with the content team', '25/05/2023', 6, 3, 'In Progress'),
                                                                                                                                                                    (9, 'Content Review and Editing', 'Review and edit the content for consistency and accuracy', '', '28/05/2023', 4, 5, 'To Do'),
                                                                                                                                                                    (9, 'Content Publishing', 'Publish the finalized content on the website', '', '30/05/2023', 4, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (10, 'UI Design', 'Design the user interface for the website', 'Create multiple design options', '25/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (10, 'UI Review and Revision', 'Review the UI design with stakeholders and make necessary revisions', '', '28/05/2023', 6, 2, 'To Do'),
                                                                                                                                                                    (10, 'UI Implementation', 'Implement the finalized UI design in the frontend', '', '30/05/2023', 6, 2, 'To Do'),
                                                                                                                                                                    (10, 'UI Testing', 'Perform testing of the implemented UI design for usability', '', '02/06/2023', 4, 4, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (11, 'Requirement Analysis', 'Analyze project requirements and create a requirements document', '', '10/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (11, 'System Design', 'Design the system architecture for the project', 'Collaborate with the development team', '15/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (11, 'Database Design', 'Design the database structure and entity relationships', '', '20/05/2023', 6, 3, 'Done'),
                                                                                                                                                                    (11, 'Frontend Development', 'Develop frontend components for the project', '', '25/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (11, 'Backend Development', 'Implement backend functionality based on requirements', '', '30/05/2023', 8, 1, 'Done');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (12, 'UI Design', 'Design the user interface for the project', 'Create multiple design options', '12/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (12, 'UI Review and Revision', 'Review the UI design with stakeholders and make necessary revisions', '', '15/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (12, 'UI Implementation', 'Implement the finalized UI design in the frontend', '', '18/05/2023', 6, 3, 'To Do'),
                                                                                                                                                                    (12, 'UI Testing', 'Perform testing of the implemented UI design for usability', '', '20/05/2023', 4, 5, 'To Do'),
                                                                                                                                                                    (12, 'Documentation', 'Prepare documentation for the project', '', '22/05/2023', 4, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (13, 'Backend API Development', 'Develop backend APIs for data retrieval', '', '15/05/2023', 6, 3, 'Done'),
                                                                                                                                                                    (13, 'Frontend Development for User Dashboard', 'Develop frontend components for the user dashboard', '', '20/05/2023', 6, 3, 'Done'),
                                                                                                                                                                    (13, 'Integration Testing', 'Perform integration testing for the implemented functionality', '', '25/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (13, 'Documentation', 'Prepare documentation for the implemented functionality', '', '28/05/2023', 4, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (14, 'Database Design and Setup', 'Design and set up the database structure', 'Refer to the project requirements', '18/05/2023', 6, 3, 'Done'),
                                                                                                                                                                    (14, 'Backend API Development', 'Develop backend APIs for data manipulation', '', '22/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (14, 'Integration Testing', 'Perform integration testing for the implemented APIs', '', '25/05/2023', 4, 5, 'Done'),
                                                                                                                                                                    (14, 'Documentation', 'Prepare documentation for the implemented functionalities', '', '28/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (14, 'Security Audit', 'Conduct a security audit of the implemented functionalities', '', '30/05/2023', 6, 2, 'To Do'),
                                                                                                                                                                    (14, 'Performance Testing', 'Perform performance testing of the implemented functionalities', '', '02/06/2023', 6, 3, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (15, 'Requirement Gathering', 'Gather requirements from stakeholders', 'Schedule meetings with stakeholders', '12/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (15, 'System Design', 'Design the overall system architecture', '', '15/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (15, 'Backend Development', 'Implement backend functionality based on requirements', '', '18/05/2023', 8, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (16, 'Data Collection', 'Collect relevant data for analysis', 'Refer to data sources provided', '15/05/2023', 6, 2, 'Done'),
                                                                                                                                                                    (16, 'Data Analysis', 'Analyze collected data and extract insights', '', '18/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (16, 'Report Generation', 'Generate a report with the findings and recommendations', '', '22/05/2023', 6, 3, 'Done');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (17, 'Prototype Design', 'Design a prototype for the new feature', 'Use wireframing tools', '18/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (17, 'Feedback Gathering', 'Gather feedback on the prototype from stakeholders', '', '22/05/2023', 4, 5, 'To Do'),
                                                                                                                                                                    (17, 'Prototype Iteration', 'Iterate on the prototype based on feedback', '', '25/05/2023', 6, 2, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (18, 'Content Creation', 'Create engaging content for the website', 'Collaborate with the content team', '22/05/2023', 6, 3, 'In Progress'),
                                                                                                                                                                    (18, 'Content Review and Editing', 'Review and edit the content for consistency and accuracy', '', '25/05/2023', 4, 5, 'To Do'),
                                                                                                                                                                    (18, 'Content Publishing', 'Publish the finalized content on the website', '', '28/05/2023', 4, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (19, 'Market Research', 'Conduct market research to identify target audience', '', '15/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (19, 'Product Design', 'Design the product features and user interface', '', '18/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (19, 'Prototype Development', 'Develop a functional prototype of the product', '', '22/05/2023', 10, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (20, 'Backend API Development', 'Develop backend APIs for data retrieval', '', '18/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (20, 'Frontend Development', 'Implement frontend components based on design', '', '22/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (20, 'Integration Testing', 'Perform integration testing for the implemented functionality', '', '25/05/2023', 4, 5, 'Done');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (21, 'Data Collection', 'Collect data from various sources for analysis', '', '22/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (21, 'Data Analysis', 'Analyze the collected data and derive insights', '', '25/05/2023', 8, 1, 'To Do'),
                                                                                                                                                                    (21, 'Report Generation', 'Generate a report summarizing the analysis findings', '', '28/05/2023', 6, 4, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (22, 'Requirement Gathering', 'Gather project requirements from stakeholders', 'Schedule meetings with stakeholders', '25/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (22, 'System Design', 'Design the overall system architecture for the project', '', '28/05/2023', 8, 1, 'To Do'),
                                                                                                                                                                    (22, 'Backend Development', 'Implement backend functionality based on requirements', '', '30/05/2023', 8, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (23, 'Planning Meeting', 'Conduct a project planning meeting with stakeholders', '', '15/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (23, 'Resource Allocation', 'Allocate resources for the project tasks', '', '18/05/2023', 6, 3, 'In Progress'),
                                                                                                                                                                    (23, 'Task Assignment', 'Assign tasks to team members', '', '22/05/2023', 6, 2, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (24, 'Wireframe Design', 'Create wireframes for the project UI', '', '18/05/2023', 6, 2, 'Done'),
                                                                                                                                                                    (24, 'UI Development', 'Develop frontend components based on wireframes', '', '22/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (24, 'UI Testing', 'Perform testing of the implemented UI for usability', '', '25/05/2023', 4, 5, 'Done');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (25, 'Backend API Development', 'Develop backend APIs for data manipulation', '', '22/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (25, 'Integration Testing', 'Perform integration testing for the implemented APIs', '', '25/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (25, 'Documentation', 'Prepare documentation for the implemented functionalities', '', '28/05/2023', 4, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (26, 'Database Design and Setup', 'Design and set up the project database', '', '25/05/2023', 6, 2, 'To Do'),
                                                                                                                                                                    (26, 'Backend Development', 'Implement backend functionality based on requirements', '', '28/05/2023', 8, 1, 'To Do'),
                                                                                                                                                                    (26, 'Testing and Bug Fixing', 'Perform testing and fix any identified bugs', '', '30/05/2023', 8, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (27, 'Research and Analysis', 'Conduct research and analysis on the target market', '', '15/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (27, 'Product Design', 'Design the product features and user interface', '', '18/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (27, 'Prototype Development', 'Develop a functional prototype of the product', '', '22/05/2023', 10, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (28, 'Backend API Development', 'Develop backend APIs for data retrieval', '', '18/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (28, 'Frontend Development', 'Implement frontend components based on design', '', '22/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (28, 'Integration Testing', 'Perform integration testing for the implemented functionality', '', '25/05/2023', 4, 5, 'Done');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (29, 'Data Collection', 'Collect data from various sources for analysis', '', '22/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (29, 'Data Analysis', 'Analyze the collected data and derive insights', '', '25/05/2023', 8, 1, 'To Do'),
                                                                                                                                                                    (29, 'Report Generation', 'Generate a report summarizing the analysis findings', '', '28/05/2023', 6, 4, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (30, 'Requirement Gathering', 'Gather project requirements from stakeholders', 'Schedule meetings with stakeholders', '25/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (30, 'System Design', 'Design the overall system architecture for the project', '', '28/05/2023', 8, 1, 'To Do'),
                                                                                                                                                                    (30, 'Backend Development', 'Implement backend functionality based on requirements', '', '30/05/2023', 8, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (31, 'Planning Meeting', 'Conduct a project planning meeting with stakeholders', '', '15/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (31, 'Resource Allocation', 'Allocate resources for the project tasks', '', '18/05/2023', 6, 4, 'In Progress'),
                                                                                                                                                                    (31, 'Task Assignment', 'Assign tasks to team members', '', '22/05/2023', 6, 3, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (32, 'Wireframe Design', 'Create wireframes for the project UI', '', '18/05/2023', 6, 4, 'Done'),
                                                                                                                                                                    (32, 'UI Development', 'Develop frontend components based on wireframes', '', '22/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (32, 'UI Testing', 'Perform testing of the implemented UI for usability', '', '25/05/2023', 4, 5, 'Done');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (33, 'Backend API Development', 'Develop backend APIs for data manipulation', '', '22/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (33, 'Integration Testing', 'Perform integration testing for the implemented APIs', '', '25/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (33, 'Documentation', 'Prepare documentation for the implemented functionalities', '', '28/05/2023', 4, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (34, 'Database Design and Setup', 'Design and set up the project database', '', '25/05/2023', 6, 2, 'To Do'),
                                                                                                                                                                    (34, 'Backend Development', 'Implement backend functionality based on requirements', '', '28/05/2023', 8, 1, 'To Do'),
                                                                                                                                                                    (34, 'Testing and Bug Fixing', 'Perform testing and fix any identified bugs', '', '30/05/2023', 8, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (35, 'Research and Analysis', 'Conduct research and analysis on the target market', '', '15/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (35, 'Product Design', 'Design the product features and user interface', '', '18/05/2023', 8, 1, 'In Progress'),
                                                                                                                                                                    (35, 'Prototype Development', 'Develop a functional prototype of the product', '', '22/05/2023', 10, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (36, 'Backend API Development', 'Develop backend APIs for data retrieval', '', '18/05/2023', 8, 1, 'Done'),
                                                                                                                                                                    (36, 'Frontend Development', 'Implement frontend components based on design', '', '22/05/2023', 8, 2, 'Done'),
                                                                                                                                                                    (36, 'Integration Testing', 'Perform integration testing for the implemented functionality', '', '25/05/2023', 4, 5, 'Done');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (37, 'Data Collection', 'Collect data from various sources for analysis', '', '22/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (37, 'Data Analysis', 'Analyze the collected data and derive insights', '', '25/05/2023', 8, 1, 'To Do'),
                                                                                                                                                                    (37, 'Report Generation', 'Generate a report summarizing the analysis findings', '', '28/05/2023', 6, 4, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (38, 'Requirement Gathering', 'Gather project requirements from stakeholders', 'Schedule meetings with stakeholders', '25/05/2023', 6, 2, 'In Progress'),
                                                                                                                                                                    (38, 'System Design', 'Design the overall system architecture for the project', '', '28/05/2023', 8, 1, 'To Do'),
                                                                                                                                                                    (38, 'Backend Development', 'Implement backend functionality based on requirements', '', '30/05/2023', 8, 1, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (39, 'Planning Meeting', 'Conduct a project planning meeting with stakeholders', '', '15/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (39, 'Resource Allocation', 'Allocate resources for the project tasks', '', '18/05/2023', 6, 3, 'In Progress'),
                                                                                                                                                                    (39, 'Task Assignment', 'Assign tasks to team members', '', '22/05/2023', 6, 4, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (40, 'Wireframe Design', 'Create wireframes for the project UI', '', '18/05/2023', 6, 4, 'Done'),
                                                                                                                                                                    (40, 'UI Development', 'Develop frontend components based on wireframes', '', '22/05/2023', 8, 5, 'Done'),
                                                                                                                                                                    (40, 'UI Testing', 'Perform testing of the implemented UI for usability', '', '25/05/2023', 4, 2, 'Done');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (41, 'Backend API Development', 'Develop backend APIs for data manipulation', '', '22/05/2023', 8, 5, 'In Progress'),
                                                                                                                                                                    (41, 'Integration Testing', 'Perform integration testing for the implemented APIs', '', '25/05/2023', 4, 5, 'In Progress'),
                                                                                                                                                                    (41, 'Documentation', 'Prepare documentation for the implemented functionalities', '', '28/05/2023', 4, 4, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (42, 'Database Design and Setup', 'Design and set up the project database', '', '25/05/2023', 6, 2, 'To Do'),
                                                                                                                                                                    (42, 'Backend Development', 'Implement backend functionality based on requirements', '', '28/05/2023', 8, 5, 'To Do'),
                                                                                                                                                                    (42, 'Testing and Bug Fixing', 'Perform testing and fix any identified bugs', '', '30/05/2023', 8, 5, 'To Do');

INSERT INTO `calendue`.`task` (`subproject_id`, `task_name`, `task_description`, `task_comment`, `task_deadline`, `task_hours`, `task_priority`, `task_status`) VALUES
                                                                                                                                                                    (43, 'Research and Analysis', 'Conduct research and analysis on the target market', '', '15/05/2023', 6, 4, 'In Progress'),
                                                                                                                                                                    (43, 'Product Design', 'Design the product features and user interface', '', '18/05/2023', 8, 3, 'In Progress'),
                                                                                                                                                                    (43, 'Prototype Development', 'Develop a functional prototype of the product', '', '22/05/2023', 10, 4, 'To Do');

/*Test data for user table*/
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user@email.kea', '1', 'User Usersen');
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user2', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user2@email.kea', '0', 'Ben Bensen');
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user3', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user3@email.kea', '0', 'Adam Adamsen');
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user4', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user4@email.kea', '0', 'Lone Lonesen');
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user5', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user5@email.kea', '0', 'Kim Kimsen');
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user6', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user6@email.kea', '0', 'Karen Karensen');
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user7', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user7@email.kea', '0', 'Hans Hansen');
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user8', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user8@email.kea', '0', 'Simone Simonesen');
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user9', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user9@email.kea', '0', 'Lars Larsen');
INSERT INTO `calendue`.`user` (`username`, `password`, `email`, `is_admin`, `full_name`) VALUES ('user10', '$2a$10$rK3VO4Xd8cYNs0X6qsCWCuKSPEspK4xkEeXAr3rLjOEY1Xwayr9jS', 'user10@email.kea', '0', 'Gandalf Gandalfsen');

/* Test data for project_user table*/
INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (1, 1, 'Project Leader'),
                                                                            (1, 2, 'Developer'),
                                                                            (1, 3, 'Developer'),
                                                                            (1, 4, 'Developer'),
                                                                            (1, 5, 'Developer'),
                                                                            (1, 6, 'Developer'),
                                                                            (1, 7, 'Developer'),
                                                                            (1, 8, 'Developer'),
                                                                            (1, 9, 'Developer'),
                                                                            (1, 10, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (2, 1, 'Project Leader'),
                                                                            (2, 2, 'Developer'),
                                                                            (2, 3, 'Developer'),
                                                                            (2, 4, 'Developer'),
                                                                            (2, 5, 'Developer'),
                                                                            (2, 6, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (3, 1, 'Project Leader'),
                                                                            (3, 2, 'Developer'),
                                                                            (3, 3, 'Developer'),
                                                                            (3, 4, 'Developer'),
                                                                            (3, 5, 'Developer'),
                                                                            (3, 6, 'Developer'),
                                                                            (3, 7, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (4, 1, 'Project Leader'),
                                                                            (4, 2, 'Developer'),
                                                                            (4, 3, 'Developer'),
                                                                            (4, 4, 'Developer'),
                                                                            (4, 5, 'Developer'),
                                                                            (4, 6, 'Developer'),
                                                                            (4, 7, 'Developer'),
                                                                            (4, 8, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (5, 1, 'Project Leader'),
                                                                            (5, 2, 'Developer'),
                                                                            (5, 3, 'Developer'),
                                                                            (5, 4, 'Developer'),
                                                                            (5, 5, 'Developer'),
                                                                            (5, 6, 'Developer'),
                                                                            (5, 7, 'Developer'),
                                                                            (5, 8, 'Developer'),
                                                                            (5, 9, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (6, 1, 'Project Leader'),
                                                                            (6, 2, 'Developer'),
                                                                            (6, 3, 'Developer'),
                                                                            (6, 4, 'Developer'),
                                                                            (6, 5, 'Developer'),
                                                                            (6, 6, 'Developer'),
                                                                            (6, 7, 'Developer'),
                                                                            (6, 8, 'Developer'),
                                                                            (6, 9, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (7, 1, 'Project Leader'),
                                                                            (7, 2, 'Developer'),
                                                                            (7, 3, 'Developer'),
                                                                            (7, 4, 'Developer'),
                                                                            (7, 5, 'Developer'),
                                                                            (7, 6, 'Developer'),
                                                                            (7, 7, 'Developer'),
                                                                            (7, 8, 'Developer'),
                                                                            (7, 9, 'Developer'),
                                                                            (7, 10, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (8, 1, 'Project Leader'),
                                                                            (8, 2, 'Developer'),
                                                                            (8, 3, 'Developer'),
                                                                            (8, 4, 'Developer'),
                                                                            (8, 5, 'Developer'),
                                                                            (8, 6, 'Developer'),
                                                                            (8, 7, 'Developer'),
                                                                            (8, 8, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (9, 1, 'Project Leader'),
                                                                            (9, 2, 'Developer'),
                                                                            (9, 3, 'Developer'),
                                                                            (9, 4, 'Developer'),
                                                                            (9, 5, 'Developer'),
                                                                            (9, 6, 'Developer'),
                                                                            (9, 7, 'Developer'),
                                                                            (9, 8, 'Developer'),
                                                                            (9, 9, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (10, 1, 'Project Leader'),
                                                                            (10, 2, 'Developer'),
                                                                            (10, 3, 'Developer'),
                                                                            (10, 4, 'Developer'),
                                                                            (10, 5, 'Developer'),
                                                                            (10, 6, 'Developer'),
                                                                            (10, 7, 'Developer'),
                                                                            (10, 8, 'Developer'),
                                                                            (10, 9, 'Developer');
INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (11, 1, 'Project Leader'),
                                                                            (11, 2, 'Developer'),
                                                                            (11, 3, 'Developer'),
                                                                            (11, 4, 'Developer'),
                                                                            (11, 5, 'Developer'),
                                                                            (11, 6, 'Developer'),
                                                                            (11, 7, 'Developer'),
                                                                            (11, 8, 'Developer'),
                                                                            (11, 9, 'Developer'),
                                                                            (11, 10, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (12, 1, 'Project Leader'),
                                                                            (12, 2, 'Developer'),
                                                                            (12, 3, 'Developer'),
                                                                            (12, 4, 'Developer'),
                                                                            (12, 5, 'Developer'),
                                                                            (12, 6, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (13, 1, 'Project Leader'),
                                                                            (13, 2, 'Developer'),
                                                                            (13, 3, 'Developer'),
                                                                            (13, 4, 'Developer'),
                                                                            (13, 5, 'Developer'),
                                                                            (13, 6, 'Developer'),
                                                                            (13, 7, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (14, 1, 'Project Leader'),
                                                                            (14, 2, 'Developer'),
                                                                            (14, 3, 'Developer'),
                                                                            (14, 4, 'Developer'),
                                                                            (14, 5, 'Developer'),
                                                                            (14, 6, 'Developer'),
                                                                            (14, 7, 'Developer'),
                                                                            (14, 8, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (15, 1, 'Project Leader'),
                                                                            (15, 2, 'Developer'),
                                                                            (15, 3, 'Developer'),
                                                                            (15, 4, 'Developer'),
                                                                            (15, 5, 'Developer'),
                                                                            (15, 6, 'Developer'),
                                                                            (15, 7, 'Developer'),
                                                                            (15, 8, 'Developer'),
                                                                            (15, 9, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (16, 1, 'Project Leader'),
                                                                            (16, 2, 'Developer'),
                                                                            (16, 3, 'Developer'),
                                                                            (16, 4, 'Developer'),
                                                                            (16, 5, 'Developer'),
                                                                            (16, 6, 'Developer'),
                                                                            (16, 7, 'Developer'),
                                                                            (16, 8, 'Developer'),
                                                                            (16, 9, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (17, 1, 'Project Leader'),
                                                                            (17, 2, 'Developer'),
                                                                            (17, 3, 'Developer'),
                                                                            (17, 4, 'Developer'),
                                                                            (17, 5, 'Developer'),
                                                                            (17, 6, 'Developer'),
                                                                            (17, 7, 'Developer'),
                                                                            (17, 8, 'Developer'),
                                                                            (17, 9, 'Developer'),
                                                                            (17, 10, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (18, 1, 'Project Leader'),
                                                                            (18, 2, 'Developer'),
                                                                            (18, 3, 'Developer'),
                                                                            (18, 4, 'Developer'),
                                                                            (18, 5, 'Developer'),
                                                                            (18, 6, 'Developer'),
                                                                            (18, 7, 'Developer'),
                                                                            (18, 8, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (19, 1, 'Project Leader'),
                                                                            (19, 2, 'Developer'),
                                                                            (19, 3, 'Developer'),
                                                                            (19, 4, 'Developer'),
                                                                            (19, 5, 'Developer'),
                                                                            (19, 6, 'Developer'),
                                                                            (19, 7, 'Developer'),
                                                                            (19, 8, 'Developer'),
                                                                            (19, 9, 'Developer');

INSERT INTO `calendue`.`project_user` (`project_id`, `user_id`, `role`) VALUES
                                                                            (20, 1, 'Project Leader'),
                                                                            (20, 2, 'Developer'),
                                                                            (20, 3, 'Developer'),
                                                                            (20, 4, 'Developer'),
                                                                            (20, 5, 'Developer'),
                                                                            (20, 6, 'Developer'),
                                                                            (20, 7, 'Developer'),
                                                                            (20, 8, 'Developer'),
                                                                            (20, 9, 'Developer');
/* Test data for task_user table*/
INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (1, 1),
                                                              (1, 2),
                                                              (2, 1),
                                                              (2, 3),
                                                              (3, 1),
                                                              (3, 4),
                                                              (4, 1),
                                                              (4, 5),
                                                              (5, 1),
                                                              (5, 6),
                                                              (6, 2),
                                                              (7, 3),
                                                              (8, 4),
                                                              (9, 5),
                                                              (10, 6);

INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (11, 1),
                                                              (11, 2),
                                                              (12, 1),
                                                              (12, 3),
                                                              (13, 1),
                                                              (13, 4),
                                                              (14, 1),
                                                              (14, 5),
                                                              (15, 2),
                                                              (15, 6),
                                                              (16, 3),
                                                              (16, 7),
                                                              (17, 4),
                                                              (17, 8);

INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (18, 1),
                                                              (18, 2),
                                                              (19, 1),
                                                              (19, 3),
                                                              (20, 1),
                                                              (20, 4),
                                                              (21, 2),
                                                              (21, 5),
                                                              (22, 3),
                                                              (22, 6),
                                                              (23, 4),
                                                              (23, 7),
                                                              (24, 5),
                                                              (24, 8),
                                                              (25, 6),
                                                              (25, 9);

INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (26, 1),
                                                              (26, 2),
                                                              (26, 3),
                                                              (27, 1),
                                                              (27, 4),
                                                              (28, 1),
                                                              (28, 5),
                                                              (29, 2),
                                                              (30, 3),
                                                              (30, 6),
                                                              (31, 4),
                                                              (31, 7),
                                                              (32, 5),
                                                              (32, 8);

INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (33, 1),
                                                              (33, 2),
                                                              (33, 3),
                                                              (34, 1),
                                                              (34, 4),
                                                              (35, 1),
                                                              (35, 5),
                                                              (36, 2),
                                                              (36, 6),
                                                              (37, 3),
                                                              (37, 7),
                                                              (38, 4),
                                                              (38, 8),
                                                              (39, 5),
                                                              (39, 9);

INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (40, 1),
                                                              (40, 2),
                                                              (40, 3),
                                                              (41, 1),
                                                              (41, 4),
                                                              (42, 1),
                                                              (42, 5),
                                                              (43, 2),
                                                              (43, 6),
                                                              (44, 3),
                                                              (44, 7),
                                                              (45, 4),
                                                              (45, 8),
                                                              (46, 5),
                                                              (46, 9);

INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (47, 1),
                                                              (47, 2),
                                                              (47, 3),
                                                              (48, 1),
                                                              (48, 4),
                                                              (49, 1),
                                                              (49, 5),
                                                              (50, 2),
                                                              (50, 6),
                                                              (51, 3),
                                                              (51, 7),
                                                              (52, 4),
                                                              (52, 8),
                                                              (53, 5),
                                                              (53, 9),
                                                              (54, 6),
                                                              (54, 10);

INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (55, 1),
                                                              (55, 2),
                                                              (55, 3),
                                                              (56, 1),
                                                              (56, 4),
                                                              (57, 1),
                                                              (57, 5),
                                                              (58, 2),
                                                              (58, 6),
                                                              (59, 3),
                                                              (60, 4),
                                                              (60, 7),
                                                              (61, 5),
                                                              (62, 6);

INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (63, 1),
                                                              (63, 2),
                                                              (63, 3),
                                                              (64, 1),
                                                              (64, 4),
                                                              (65, 1),
                                                              (65, 5),
                                                              (66, 2),
                                                              (66, 6),
                                                              (67, 3),
                                                              (68, 4),
                                                              (69, 5),
                                                              (70, 6),
                                                              (70, 10);

INSERT INTO `calendue`.`task_user` (`task_id`, `user_id`) VALUES
                                                              (71, 1),
                                                              (71, 2),
                                                              (71, 3),
                                                              (72, 1),
                                                              (72, 4),
                                                              (73, 1),
                                                              (73, 5),
                                                              (74, 2),
                                                              (75, 3),
                                                              (75, 6),
                                                              (76, 4),
                                                              (77, 5),
                                                              (77, 9),
                                                              (78, 6),
                                                              (78, 10),
                                                              (79, 7),
                                                              (80, 8),
                                                              (81, 9),
                                                              (82, 10);