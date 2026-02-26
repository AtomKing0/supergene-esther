# Report Generator Agent Memory

## Project Context
- **Project**: Solitaire Currency Analysis
- **Main Deliverable**: Candy Solitaire game economy reverse engineering analysis
- **Output Directory**: `/docs/04-report/features/`
- **Status**: PDCA Cycle #1 Complete

## Key Patterns Learned

### 1. Analysis Project Reports
When handling reverse engineering/analysis projects (not feature development):
- Treat "implementation" as the analysis work itself
- Focus on findings, patterns, and actionable insights
- Include comprehensive tables and comparative analyses
- Provide benchmarking recommendations for future projects

### 2. Document Structure for Game Economy Analysis
- Overview section with source data volume
- Currency system taxonomy (soft vs hard, acquisition vs consumption)
- Event system categorization and impact analysis
- Formula and parameter extraction
- Design principles and pattern identification
- Competitor comparison and recommendation framework

### 3. Korean Technical Writing Standards
- Use formal hierarchical numbering (1. → 1.1 → 1.1.1)
- Include tables with consistent formatting (item | value | effect)
- Provide visual diagrams using ASCII for flow and relationships
- Mix quantitative (tables) and qualitative (analysis) content
- Reference all conclusions with source evidence

### 4. Report Sections for Analysis Projects
1. **Summary** - Project overview with completion metrics
2. **Related Documents** - Link to Plan/Design/Analysis documents
3. **Purpose & Methodology** - Why analysis was done and how
4. **Key Findings** - Detailed breakdowns with subsections
5. **Synthesis & Insights** - Cross-domain patterns and principles
6. **Benchmarking** - Comparison and recommendations
7. **Lessons & Retrospective** - What was learned for next cycle
8. **Next Steps** - Immediate and long-term follow-up tasks
9. **Changelog** - Version history and metrics

### 5. Common Metrics for Game Economy Analysis
- Currency types and their limitations
- Acquisition paths and daily caps
- Consumption endpoints (count, average cost)
- Event diversity (number and categorization)
- Analytics integration points
- Player segment differentiation paths

### 6. Formatting Preferences
- Use code blocks for formulas: `player_coins = Σ(acquisition_paths)`
- Visual flow diagrams with indentation and arrows
- Emoji indicators: ✅/⏸️/❌ for status tracking
- Table-heavy presentation for structured data
- Nested bullet lists for hierarchical information

## Common Pitfalls Avoided
- ✅ Did NOT treat analysis as incomplete feature development
- ✅ Did NOT estimate "implementation time" (irrelevant for analysis)
- ✅ Did NOT mark deferred items as failures
- ✅ DID focus on completeness of analysis scope
- ✅ DID provide actionable recommendations
- ✅ DID document methodology for reproducibility

## Tools & Commands Used
- bkit-templates (report.template.md)
- PDCA skill framework
- Markdown table generation
- Flow diagram ASCII art

## Next Cycle Recommendations
- Implement parameter extraction tool for IL2CPP parsing
- Develop competitive analysis template
- Create LTV simulation framework
- Plan benchmark comparison structure

---

**Last Updated**: 2026-02-26
**Memories Recorded**: 6 major patterns
