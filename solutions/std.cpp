#include <map>
#include <stdio.h>
#include <string.h>
#include <algorithm>
using namespace std;

int gint(){
	char c; int f=1;
	while(c=getchar(),c<48||c>57)
		if(c=='-')f=-1;
	int x=0;
	for(;c>47&&c<58;c=getchar()){
		x=x*10+c-48;
	}
	return x*f;
}

#define max_N 100005
#define Mod 1000000007

int eu[max_N],ev[max_N];

struct edge{
	int v,n;
	edge(int v=0,int n=0):v(v),n(n){}
}e[max_N<<1];

int head[max_N],tot,d[max_N];

void add_edge(int u,int v){
	e[++tot]=edge(v,head[u]),head[u]=tot;
	e[++tot]=edge(u,head[v]),head[v]=tot;
}

int n,m,k;

int qpow(int x,int k){
	if(k<0)return 0; 
	int res=1;
	for(;k;x=1ll*x*x%Mod,k>>=1)
		if(k&1)res=1ll*res*x%Mod;
	return res;
}

int ans;

int C(int n,int m){
	long long res=1;
	for(int i=1;i<=m;++i)res=res*(n-i+1)/i;
	return res%Mod;
}

map<int,bool>G[max_N];

int solve_cir3(){
	int res=0;
	for(int i=1;i<=m;++i){
		int u=eu[i],v=ev[i];
		if(d[u]>d[v])swap(u,v);
		for(int j=head[u];j;j=e[j].n)if(G[e[j].v][v])++res;
	}
	return res;
}

void solve(){
	int s2=m;
	ans=(ans+1ll*s2*qpow(2,n-2)%Mod)%Mod;
	
	int s3=0,t1=0;
	for(int i=1;i<=n;++i){
		t1=(t1+1ll*C(d[i],2)*6%Mod)%Mod;
	}
	int t2=1ll*solve_cir3()*2%Mod;
	s3=(t1+t2)%Mod;
	ans=(ans+1ll*s3*qpow(2,n-3)%Mod)%Mod; 

	int s4=0,t3=0,t4=0;
	for(int i=1,tmp;i<=m;++i){
		tmp=1ll*(d[eu[i]]-1)*(d[ev[i]]-1)*6%Mod;
		t3=(t3+tmp)%Mod;
	}
	t3=(t3-1ll*t2*3%Mod+Mod)%Mod;
	for(int i=1,tmp;i<=n;++i){
		tmp=1ll*C(d[i],3)*6%Mod;
		t4=(t4+tmp)%Mod;
	}
	s4=(t3+t4)%Mod;
	for(int i=1,tmp;i<=m;++i){
		tmp=1ll*(m-d[eu[i]]-d[ev[i]]+1)*3%Mod;
		s4=(s4+tmp)%Mod;
	} 
	ans=(ans+1ll*s4*qpow(2,n-4)%Mod)%Mod;
	
	int s5=1ll*t1*(m-2)%Mod;
	s5=(s5-1ll*t2*3%Mod+Mod)%Mod;
	s5=(s5-1ll*t3*2%Mod+Mod)%Mod;
	s5=(s5-1ll*t4*3%Mod+Mod)%Mod;
	ans=(ans+1ll*s5*qpow(2,n-5)%Mod)%Mod;
	
	int s6=1ll*m*m*m%Mod;
	s6=(s6-s2+Mod)%Mod;
	s6=(s6-s3+Mod)%Mod;
	s6=(s6-s4+Mod)%Mod;
	s6=(s6-s5+Mod)%Mod;
	ans=(ans+1ll*s6*qpow(2,n-6)%Mod)%Mod;
}

int main(){
	n=gint(),m=gint();
	for(int i=1;i<=m;++i){
		eu[i]=gint(),ev[i]=gint();
		add_edge(eu[i],ev[i]);
		G[eu[i]][ev[i]]=G[ev[i]][eu[i]]=1;
		++d[eu[i]],++d[ev[i]];	
	}	
	solve();
	ans=1ll*ans*qpow(2,1ll*n*(Mod-2)%(Mod-1))%Mod; 
	printf("%d\n",ans);
	return 0;
}

