#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
struct data
{
	char name[20];
	char pass[20];
	float score; 
}info, userDetails, result;

void signup()
{
	FILE *log;
	log = fopen("list.txt", "a");
	if (log == NULL)
	{
		printf("file does not exist");
	}
	else 
	{
		printf("\n\t\t\t enter the name: ");
		scanf("%s",info.name);
		printf("\n\t\t\t enter the pass: ");
		scanf("%s", info.pass);
		fprintf(log, "%s %s\n",info.name, info.pass);
	}
	fclose(log);
}
int login()
{
	char lname[20];
	char pss[20];
	FILE *log;
	log = fopen("list.txt", "r");
	 	printf("\n\t\t\t enter the name: ");
		scanf("%s",lname);
		printf("\n\t\t\t enter the pass: ");
		scanf("%s", pss);
	int found = 0;
	int auth = 0;
		
	while(fscanf(log, "%s %s\n",info.name, info.pass))
	{
		if (strcmp(lname,info.name)== 0)
		{
			found = 1;
			if(strcmp(pss,info.pass) == 0){
				printf("\t\tsuccessfully logged in\n");
				strcpy(userDetails.name, lname);
				strcpy(userDetails.pass, pss);
				auth = 1;
				break;
			}
			printf("\t\tPassword is incorrect\n");
			break;
			}
 		else {
 		if(!found){
		printf("\n\t\tNo Such User Exits!\n");
		break;
	}
	}
}
	fclose(log);
	return auth;
};
void display()
{
	
	FILE *log;
	log = fopen("result.txt", "r");
	if (log == NULL)
	{
		printf("file does not exist");
	}
	else
	 {
	 	
	 	printf("\n\n\t\t\t\tName		score");
		 while (!feof(log))
		 {
		 
      fscanf(log,"%s %f\n",&info.name, &result.score);
      printf(" \n\n\t\t\t\t%s          %.2f\n ",info.name, result.score);
}
	fclose(log);
}
}
void search()
{
	FILE *log;
	char name[20];
	fflush(stdin);
	printf("\n\n \t\t enter name to search ");
	scanf("%s", &name);
	log = fopen("result.txt", "r");
	if ( log == NULL)
	{
		printf("File does not exist");
	}
	else 
	{
	while(fscanf(log, "%s %f \n",&info.name, &result.score))
	{
		if (strcmp(name,info.name)== 0)
		{
		 printf(" \n\n \t\t You searched for student: %s %.2f", info.name, result.score);
		 break;
		}	
		 
	}
	fclose(log);
}
}
int main()
{
	int level1=0, level2=0, level3=0, total = 0;
	menu:
		printf("\n\n\t\t\t\t\t======================================\n");
		printf("\t\t\t\t\t Welcome to NOESIS\n");
		printf("\t\t\t\t\t please select to continue\n");
	printf(" \n\n\t\t\t\t\t -> 1 teacher \n\t\t\t\t\t -> 2 student ");
	int opt;
	scanf("%d", &opt);
	switch(opt)
	{
		case 1:
			system("cls");
			printf( " \n\n\t\t\t\t -> 1 sign \n\n\t\t\t\t -> 2 login");
	int opt1;
	scanf("%d", &opt);
	switch(opt)
	{
		case 1:
			signup();
			system("cls");
			goto menu;
			break;
		case 2:
				printf("\t\t\t\t Teacher \n");
			if(!login()){
				printf("\n\t\t\tyou are not a teacher\n");
				return;
			}
			tmenu:
				system("cls");
			printf(" \n\n\t\t\t\t -> 1. Display student quiz record\n ");
			printf(" \n\n\t\t\t\t -> 2. search particular student record\n ");
			scanf("%d", &opt);
			switch(opt)
			{
				case 1:
					display();
					printf("\n\n \t\t press any key to continue... ");
					getch();
					system("cls");
					goto menu;
					break;
				case 2:
					search();
					printf("\n\n press any key to continue... ");
					getch();
					system("cls");
					goto menu;
					break;
				default:
					printf("wrong input\n");
					goto tmenu;
					system("cls");	
			}
		break;	
		default:
			printf("wrong input\n");
			goto menu;
			system("cls");
	}
	case 2:
		system("cls");
	printf(" \n\n\t\t -> 1 sign \n\n\t\t 2 login");
	int opt;
	scanf("%d", &opt);
	switch(opt)
	{
		case 1:
			signup();
			system("cls");
			goto menu;
			break;
		case 2:
		
			if(!login()){
				printf("You are not allowed to sit in quiz\n");
				return;
			}
			system("cls");
			printf("\n\t\t do you want to start the quiz 1 yes or 2 No ");
			int sel;
			scanf("%d", &sel);
			{
			if ( sel == 1)
			{
			system("cls");
	char question[5][150];
	char a[5], b[5], c[5], d[5];
	FILE *file = fopen("Level1.txt", "r");
	int i =0 ;
	int correct = 0;
	int wrong = 0;
	
	while(fgets(question[i], sizeof(question[i]), file)){
		system("cls");
		printf(" %s\n", question[i]);
		fscanf(file, "%s %s %s %s\n", &a, &b, &c, &d);
		if(a[0] == '_'){
			int j = 1;
			printf("a). ");
			while(a[j] != '\0'){  
				printf("%c", a[j++]);
			}
			printf("\n");
			printf("b). %s\n", b);
			printf("c). %s\n", c);
			printf("d). %s\n", d);;
		}
		else if(b[0] == '_'){
			printf("b). %s\n", a);
			int j = 1;
			printf("b). ");
			while(b[j] != '\0'){
				printf("%c", b[j++]);
			}
			printf("\n");
			printf("c). %s\n", c);
			printf("d). %s\n", d);;
			} 	
			else if(c[0] == '_'){
			printf("a). %s\n", a);
			printf("b). %s\n", b);
			int j = 1;
			printf("c). ");
			while(c[j] != '\0'){
				printf("%c", c[j++]);
			}
			printf("\n");
			
			printf("d). %s\n", d);;
		}
		else if(d[0] == '_'){
			printf("a). %s\n", a);
			printf("b). %s\n", b);
			printf("c). %s\n", c);
			int j = 1;
			printf("d). ");
			while(d[j] != '\0'){
				printf("%c", d[j++]);
			}
			printf("\n");
		}
		
		fflush(stdin);
		char ans;
		printf("You answer: ");
		scanf("%c", &ans);
		if(a[0] == '_' && ans == 'a'){
			correct++;
		}else if(b[0] == '_' && ans == 'b'){
			correct++;
		}else if(c[0] == '_' && ans == 'c'){
			correct++;
		}else if(d[0] == '_' && ans == 'd'){
			correct++;
		}else{
			wrong++;
		}
		i++; // next line ( next question) 
	
 		
			
	}
	level1 = correct;
	if (level1 >= 2)
	{
		printf("\n\n \t\tyou are qualified for qualifying round\n");
		printf("\n\n\t\tpress any key to continue playing qualifying round\n");
		getch();
		char question[10][150];
	char a[10], b[10], c[10], d[10];
	FILE *file = fopen("Level2.txt", "r");
	int i =0 ;
	int correct = 0;
	int wrong = 0;
	
	while(fgets(question[i], sizeof(question[i]), file)){
		system("cls");
		printf(" %s\n", question[i]);
		fscanf(file, "%s %s %s %s\n", &a, &b, &c, &d);
		if(a[0] == '_'){
			int j = 1;
			printf("a). ");
			while(a[j] != '\0'){
				printf("%c", a[j++]);
			}
			printf("\n");
			printf("b). %s\n", b);
			printf("c). %s\n", c);
			printf("d). %s\n", d);;
		}
		else if(b[0] == '_'){
			printf("b). %s\n", a);
			int j = 1;
			printf("b). ");
			while(b[j] != '\0'){
				printf("%c", b[j++]);
			}
			printf("\n");
			printf("c). %s\n", c);
			printf("d). %s\n", d);;
			} 	
			else if(c[0] == '_'){
			printf("a). %s\n", a);
			printf("b). %s\n", b);
			int j = 1;
			printf("c). ");
			while(c[j] != '\0'){
				printf("%c", c[j++]);
			}
			printf("\n");
			
			printf("d). %s\n", d);;
		}
		else if(d[0] == '_'){
			printf("a). %s\n", a);
			printf("b). %s\n", b);
			printf("c). %s\n", c);
			int j = 1;
			printf("d). ");
			while(d[j] != '\0'){
				printf("%c", d[j++]);
			}
			printf("\n");
		}
		
		fflush(stdin);
		char ans;
		printf("You answer: ");
		scanf("%c", &ans);
		if(a[0] == '_' && ans == 'a'){
			correct++;
		}else if(b[0] == '_' && ans == 'b'){
			correct++;
		}else if(c[0] == '_' && ans == 'c'){
			correct++;
		}else if(d[0] == '_' && ans == 'd'){
			correct++;
		}else{
			wrong++;
		}
		i++;
	
 		
			
	}
	level2 = correct;
	if (level2 >= 5)
	{
		printf("\n\n \t\t\tyou are qualified for Final round");
		printf("\n\n\t\t\tPress any key to continue....\n");
		getch();
		char question[12][150];
	char a[12], b[12], c[12], d[12];
	FILE *file = fopen("Level3.txt", "r");
	int i =0 ;
	int correct = 0;
	int wrong = 0;
	
	while(fgets(question[i], sizeof(question[i]), file)){
		system("cls");
		printf(" %s\n", question[i]);
		fscanf(file, "%s %s %s %s\n", &a, &b, &c, &d);
		if(a[0] == '_'){
			int j = 1;
			printf("a). ");
			while(a[j] != '\0'){
				printf("%c", a[j++]);
			}
			printf("\n");
			printf("b). %s\n", b);
			printf("c). %s\n", c);
			printf("d). %s\n", d);;
		}
		else if(b[0] == '_'){
			printf("b). %s\n", a);
			int j = 1;
			printf("b). ");
			while(b[j] != '\0'){
				printf("%c", b[j++]);
			}
			printf("\n");
			printf("c). %s\n", c);
			printf("d). %s\n", d);;
			} 	
			else if(c[0] == '_'){
			printf("a). %s\n", a);
			printf("b). %s\n", b);
			int j = 1;
			printf("c). ");
			while(c[j] != '\0'){
				printf("%c", c[j++]);
			}
			printf("\n");
			
			printf("d). %s\n", d);;
		}
		else if(d[0] == '_'){
			printf("a). %s\n", a);
			printf("b). %s\n", b);
			printf("c). %s\n", c);
			int j = 1;
			printf("d). ");
			while(d[j] != '\0'){
				printf("%c", d[j++]);
			}
			printf("\n");
		}
		
		fflush(stdin);
		char ans;
		printf("You answer: ");
		scanf("%c", &ans);
		if(a[0] == '_' && ans == 'a'){
			correct++;
		}else if(b[0] == '_' && ans == 'b'){
			correct++;
		}else if(c[0] == '_' && ans == 'c'){
			correct++;
		}else if(d[0] == '_' && ans == 'd'){
			correct++;
		}else{
			wrong++;
		}
		i++;	
	}
	
	level3 = correct;
	total = level1 + level2 + level3; 
//	printf("\nyour total marks are %d\n", total);
	FILE *log;
	result.score = total;
	log = fopen("result.txt", "a");
	if (log == NULL)
	{
		printf("file does not exist");
	} 
	else 
	{   
		fprintf(log ,"%s %.2f\n", info.name, result.score);
	}
	fclose(log);
   
  	}
	else {
		printf("\n\n\t\tyou have failed in warm up round ");
		printf("\n\n\t\t press any key to go menu");
	
	}
	
	}
	else {
		printf("\n\n\t\tyou have failed in warm up round ");
		printf("\n\n\t\t press any key to go menu");
	
	}
		level3 = correct;
	total = level1 + level2 + level3; 
//	printf("\nyour total marks are %d\n", total);
	FILE *log;
	result.score = total;
	log = fopen("result.txt", "a");
	if (log == NULL)
	{
		printf("file does not exist");
	} 
	else 
	{   
		fprintf(log ,"%s %.2f\n", info.name, result.score);
	}
	fclose(log);
   
	break;
		goto menu;		
	}
}
}
}

return 0;
}






