#include<bits/stdc++.h>
using namespace std;
vector<string> getRedoList(map<string, pair<bool, bool>> &transaction);
vector<string> getUndoList(map<string, pair<bool, bool>> &transaction);
void printList(vector<string> list);
void printAction(map<string, pair<string, string>> &blocks);

int main(){
    map<string, pair<bool, bool>> transaction;      // 1st bool means isCommited and 2nd bool means toBeConsidered
    map<string, pair<string, string>> blocks;       // 1st string means redo value and 2nd string means undo value
    vector<string> commands;
    vector<string> redoList, undoList;
    string trans, blockName, oldVal, newVal,line;
    int i = 0, starts = 0, ckptIndex = -1;
    freopen("input3.txt", "r", stdin);
    while(getline(cin, line)){
        line = line.substr(1, line.size() - 2); 
        commands.push_back(line);
        if(line[0] == 'S'){
            starts++;
            string singleW = "";
            for(char c : line){
                if(c != ' '){
                    singleW += c;
                }
                else if(c == ' '){
                    singleW = "";
                }
            } 
            transaction[singleW].first = false;
            transaction[singleW].second = true;
        }
        else if(line[1] == 'K'){ //k =ckpt
            ckptIndex = i;
        }
        else if(line[1] == 'O'){
            string singleW = "";
            for(char c : line){
                
                if(c!=' '){
                    singleW+=c;
                }
                else if(c==' '){
                    singleW = "";
                }
            }
            transaction[singleW].first = true;

        }
        else if(line[0] == 'T'){
            string singleW = "";
            int spaceCount = 0; // T1 A 1 2
            for(char c : line){
                
                if(c != ' '){
                    singleW += c;
                }
                else if(c == ' '){
                    spaceCount++;
                    if(spaceCount == 2) break;
                    singleW = "";
                }
            }
            blocks[singleW] = {"", ""};
        }
        i++;
    }
    if(ckptIndex != -1){
        for(i = 0; i < ckptIndex; i++){
            if(commands[i][1] == 'O'){
                string singleW;// = commands[i];
                for(char c : commands[i]){ // COMMIT T1

                if(c != ' '){
                    singleW += c;
                }
                else if(c == ' '){
                    singleW = "";
                }
            }
                transaction[singleW].second = false;
            }
        }
    }
    redoList = getRedoList(transaction);
    undoList = getUndoList(transaction);

    cout << "Redo list: ";
    printList(redoList);
    cout << "Undo list: ";
    printList(undoList);

    for(i = commands.size() - 1; i >= 0; i--){
        if(commands[i][0] == 'T'){
            string singleL = commands[i];
            string singleW="";
            int spaceCount=0;
            for(char c : singleL){
                
                if(c != ' '){
                    singleW += c;
                }
                else if(c == ' '){
                    spaceCount++;
                
                    if(spaceCount == 1){
                        trans = singleW;
                                            }
                    else if(spaceCount == 2){
                        blockName = singleW;
                    }
                    else if(spaceCount == 3){
                        oldVal = singleW;
                    }
                    singleW = "";
                }
                
            }
            newVal = singleW;
            if(!transaction[trans].second){
                continue;
            }
            auto it = blocks.begin();
            while(it != blocks.end()){
                if(it->first == blockName){
                    break;
                }
                it++;
            }
            if(it != blocks.end()){
                if(transaction[trans].first){
                    it->second.first = newVal;
                }
                else{
                    it->second.second = oldVal;
                }
            }
        }
    }
    printAction(blocks);
    return 0;
}

vector<string> getRedoList(map<string, pair<bool, bool>> &transaction){
    vector<string> redoList;
    auto it = transaction.begin();
    while(it != transaction.end()){
        if(it->second.second && it->second.first){
            redoList.push_back(it->first);
        }
        it++;
    }
    return redoList;
}

vector<string> getUndoList(map<string, pair<bool, bool>> &transaction){
    vector<string> undoList;
    auto it = transaction.begin();
    while(it != transaction.end()){
        if(it->second.second && !it->second.first){
            undoList.push_back(it->first);
        }
        it++;
    }
    return undoList;
}

void printList(vector<string> list){
    for(auto line : list){
        cout << line << " ";
    }
    cout<<endl;
}

void printAction(map<string, pair<string, string>> &blocks){
    cout << "\tRedo\t      Undo" << endl;
    auto it = blocks.begin();
    while (it != blocks.end()){
        cout << it->first << ":\t" << it->second.first << "\t| " << it->second.second << endl;
        it++;
    }
}