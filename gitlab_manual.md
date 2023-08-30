# Work with GitLab
## Creating a personal repository with the right .gitignore and a simple README.MD

### Create a blank project
To create a blank project:
1. On the left sidebar, at the top, select Create new (+) and New project/repository.
2. Select Create blank project.
3. Enter the project details:
4. 
  - In the Project name field, enter the name of your project. The name must start with a lowercase or uppercase letter (a-zA-Z), digit (0-9), emoji, or underscore (_). It can also contain dots (.), pluses (+), dashes (-), or spaces.
  - In the Project slug field, enter the path to your project. The GitLab instance uses the slug as the URL path to the project. To change the slug, first enter the project name, then change the slug.
  - In the Project deployment target (optional) field, select your project’s deployment target. This information helps GitLab better understand its users and their deployment requirements.
  - To modify the project’s viewing and access rights for users, change the Visibility Level.
  - To create README file so that the Git repository is initialized, has a default branch, and can be cloned, select Initialize repository with a README.
  - To analyze the source code in the project for known security vulnerabilities, select Enable Static Application Security Testing (SAST).

4. Select Create project.

### Connecting GitLab to a local machine

To connect the GitLab, you need to configure the ssh key on the local machine and profile.

#### Use Terminal for create ssh-key

1. Open Terminal
2. Open a terminal and run the command:
> `$ ssh-keygen -t rsa`
3. Press `Enter` while u didn't see somt like it:
> Your identification has been saved in /home/user/.ssh/id_rsa.
> Your public key has been saved in /home/user/.ssh/id_rsa.pub.
4. Next, run a command in the terminal:
> `$ cat ~/.ssh/id_rsa.pub`

The console will display the key. Copy it and paste it into the appropriate field:

![GitLab_Add_ssh](src/images/git_add_ssh.png)

#### Create and setting file `.gitconfig`

Create a gitignor file in any convenient editor and put those folders and files in it where changes will not be taken into account by the git version control system.

## Creating the develop and master branches

Branches are versions of a project’s working tree. When you create a new project, GitLab creates a default branch (which cannot be deleted) for your repository. Default branch settings can be configured at the project, subgroup, group, or instance level.

As your project grows, your team creates more branches, preferably by following branch naming patterns. Each branch represents a set of changes, which allows development work to be done in parallel. Development work in one branch does not affect another branch.

Branches are the foundation of development in a project:
1. To get started, create a branch and add commits to it.
2. When the work is ready for review, create a merge request to propose merging the changes in your branch. To streamline this process, you should follow branch naming patterns.
3. Preview changes in a branch with a review app.
4. After the contents of your branch are merged, delete the merged branch.

### Ways to create branches and switch between them

When add a branch to Git we use

`$ git branch <name of new branch>`

The branch was already created after this operation, but you are still in your previous branch. If you plan to move to another branch, including the branch you just created, you must write checkout:

`$ git checkout <name of branch>`

Git uses a special HEAD pointer that refers to the branch currently on your local branch to determine where you are now. This will cause checkout to drop HEAD onto a different branch.

![GitLab_Add_show_branch](src/images/git_branches.png)

## Setting the default `develop` branch

With `git 2.28`, you can set a `global config with this command git config --global init.defaultBranch {branchName}`

Replace `{branchName}` with the default branch name and now whenever you create a new git repo, the default branch will be this.

## Issue creation

Prerequisites:

  - You must have at least the Developer role for the project.
When viewing an issue, you can create an associated branch directly from that page. Branches created this way use the default pattern for branch names from issues, including variables.

Prerequisites:

You must have at least the Developer role for the project.
To create a branch from an issue:
1. On the left sidebar, select Search or go to and find your project.
2. Select Plan > Issues and find your issue.
3. Below the issue description, find the Create merge request dropdown list, and select to display the dropdown list.
4. Select Create branch. A default Branch name is provided, based on the default pattern for this project. If desired, enter a different Branch name.
5. Select Create branch to create the branch based on your project’s default branch.

## Creating branch to solve issue

If you create a branch called `<issue-number>-issue-description` and push that branch to gitlab, it will automatically link to that issue. For example, if you have an issue with id `654` and you create a branch called `654-some-feature` and push it to gitlab, it will link to issue `654`.

Gitlab will even ask you if you want to create a merge request and will automatically add `Closes #654` to the merge request description, which will close `issue 654` when you accept the merge request.

Also, if you go to a given issue page on gitlab, you should see a `New Branch` button that will automatically create a branch named `<issue-number>-issue-description`

## Creating merge requests

You can create a merge request from the list of merge requests.

1. On the left sidebar, select Search or go to and find your project.
2. Select Code > Merge requests.
3. In the upper-right corner, select New merge request.
4. Select a source and target branch and then Compare branches and continue.
5. Fill out the fields and select Create merge request.

## Commenting on and accepting the quest

Let's take the following repository as an example.

1. Make a fork of the repository below your name.

![GitLab_source](src/images/git_source.png)

Теперь у Вас есть собственная версия репозитория, которая связана с основным репозиторием.

![GitLab_copy](src/images/git_copy.png) 

2. In your repository, complete the task by committing it as needed. It is better not to mix different changes in one comment.

3. When you are ready to complete your task, proceed to merge queries in your repository.
   
![GitLab_request](src/images/git_merge_req.png) 

Pick Create new merge request.

4. In the form that opens, select your fork branch and the branch you want to join in the main repository (usually the master).

![GitLab_merge_app](src/images/git_merge.png)

Select branches and continue.

This is how you send a request to accept changes from the selected branch of your repository to the master or main branch of the repository with a job.

5. Fill in additional information on this form if there are special requirements for your course and click Submit merge request.

![GitLab_add_comments](src/images/git_merge_form.png)

6. Finished!

## Forming the stable version in the master with the tagging

To format the stable version and put the tag in the `master` branch in `git` follow steps:

1. Make sure you are in a stable branch.
2. Update the `master' branch to the latest version:
>`git pull origin master`
3. Reset the stable version using the `master` branch.
4. Create a commit and set the `teg` to commit:
>`git commit -m "message"`
>`git tag <table_name>`
5. Send the modified tag to the remote repository

## Wiki

If you don’t want to keep your documentation in your repository, but you want to keep it in the same project as your code, you can use the wiki GitLab provides in each GitLab project. Every wiki is a separate Git repository, so you can create wiki pages in the web interface, or locally using Git.

GitLab wikis support Markdown, Rdoc, AsciiDoc, and Org for content. Wiki pages written in Markdown support all Markdown features, and also provide some wiki-specific behavior for links.

In GitLab 13.5 and later, wiki pages display a sidebar, which you can customize. This sidebar contains a partial list of pages in the wiki, displayed as a nested tree, with sibling pages listed in alphabetical order. To view a list of all pages, select View All Pages in the sidebar.

### View a project wiki

To access a project wiki:

1. On the left sidebar, select Search or go to and find your project.
2. To display the wiki, either:
  - On the left sidebar, select Plan > Wiki.
  - On any page in the project, use the g + w wiki keyboard shortcut.
If Plan > Wiki is not listed in the left sidebar of your project, a project administrator has disabled it.
